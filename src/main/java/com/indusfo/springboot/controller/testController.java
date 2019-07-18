package com.indusfo.springboootdemo_user.controller;

import com.indusfo.springboootdemo_user.pojo.User;
import com.indusfo.springboootdemo_user.utils.RedisUtil;
import com.indusfo.springboootdemo_user.utils.responUtil.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName testController
 * @Description //TDD
 * @Author hewb
 * @Date 2019/4/20 16:53
 **/
@RestController
public class testController {
    @Resource
    RedisUtil redisUtil;

    @PostMapping("testLogin")
    public ResponseData testLogin() {

        return ResponseData.success("test放行");
    }


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostMapping("/getuser")
    public ResponseData get(String username) {
        Object o = redisUtil.get(username);

        return ResponseData.success(o);
    }

    @PostMapping("/put")
    public ResponseData put(String username, String nickname) {
        User user = new User();
        user.setVcUserName(username);
        user.setVcUserPwd(nickname);
        redisTemplate.opsForValue().set(username, user,100000);
        redisUtil.set(username, user, 100);
        return ResponseData.success("ok");
    }


}
