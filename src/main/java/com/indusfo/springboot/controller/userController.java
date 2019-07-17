package com.indusfo.springboootdemo_user.controller;

import com.indusfo.springboootdemo_user.pojo.User;

import com.indusfo.springboootdemo_user.service.UserService;
import com.indusfo.springboootdemo_user.utils.responUtil.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @ClassName userController
 * @Description //TDD
 * @Author hewb
 * @Date 2019/4/10 13:04
 **/
@RestController
@RequestMapping("user")
public class userController {
    @Autowired
    UserService userService;


    @RequestMapping("selectUser")
    public  ResponseData selectUser(User user){
        List<User> userList = userService.selectUser(user);
        return  ResponseData.success(userList);
    }


}
