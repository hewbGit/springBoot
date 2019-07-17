package com.indusfo.springboootdemo_user.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.indusfo.springboootdemo_user.pojo.User;
import com.indusfo.springboootdemo_user.security.JwtAuthenticatioToken;
import com.indusfo.springboootdemo_user.service.UserService;
import com.indusfo.springboootdemo_user.utils.JwtTokenUtils;
import com.indusfo.springboootdemo_user.utils.PasswordUtils;
import com.indusfo.springboootdemo_user.utils.RedisUtil;
import com.indusfo.springboootdemo_user.utils.SecurityUtils;
import com.indusfo.springboootdemo_user.utils.loginUtil.JwtUtil;
import com.indusfo.springboootdemo_user.utils.responUtil.ResponseData;
import com.indusfo.springboootdemo_user.vo.Login;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @ClassName loginController
 * @Description //TDD
 * @Author heweb
 * @Date 2019/4/15 14:54
 **/
@RestController
@Slf4j
public class loginController {
    @Autowired
    Producer producer;
    @Autowired
    UserService userService;
    @Resource
    RedisUtil redisUtil;
    @Autowired
     AuthenticationManager authenticationManager;

    @PostMapping("captcha.jpg")
    public void captcha(HttpServletResponse response, HttpServletRequest request) {
        try {
            response.setHeader("Cache-Control", "no-store, no-cache");
            response.setContentType("image/jpeg");
            // 生成文字验证码
            String text = producer.createText();
            // 生成图片验证码
            BufferedImage image = producer.createImage(text);
            // 保存到验证码到 session
            request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);

            ServletOutputStream out = response.getOutputStream();
            ImageIO.write(image, "jpg", out);
            IOUtils.closeQuietly(out);
        }catch (Exception e){
            log.info("生成验证码失败");
        }
    }

    @PostMapping("/login")
    public ResponseData login(@RequestBody Login login, HttpServletRequest request){
        try {
            String username = login.getUserName();
            String password = login.getPassWord();
            if (username == null) {
                return ResponseData.errorMsg("用户名不能为空");
            }
            User user1 = userService.selectByName(username);
            if (user1 == null) {
                return ResponseData.errorMsg("账号不存在");
            }
            if (!PasswordUtils.matches("e2e945517d5e434585b4", password, user1.getVcUserPwd())) {
                return ResponseData.errorMsg("密码错误");
            }

            // 系统登录认证
            JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
             redisUtil.set(username, JwtTokenUtils.getAuthenticationeFromToken(request),3000);
            return ResponseData.success(token);
        }catch (BadCredentialsException e){
            log.info(e.getMessage());
            return ResponseData.errorMsg("用户名或密码错误");
        }
    }

}
