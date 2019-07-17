package com.indusfo.springboootdemo_user.service.impl;

import com.indusfo.springboootdemo_user.mapper.userMapper;
import com.indusfo.springboootdemo_user.pojo.User;
import com.indusfo.springboootdemo_user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName userServiceImpl
 * @Description //TDD
 * @Author hewb
 * @Date 2019/4/10 13:12
 **/
@Service
public class userServiceImpl implements UserService {

    @Autowired
    userMapper userMapper;

    @Override
    public List<User> selectUser(User user) {
        List<User> users = userMapper.selectUser(user);
        return users;
    }

    @Override
    public boolean loginUser(String userName, String password) {
        boolean check = false;
        Integer integer = userMapper.loginUser(userName, password);
             if(integer!=1){
                 check=true;
             }

        return check;
    }



    @Override
    public String getToken(String username) {

    /*    //存入JWT的payload中生成token
        Map claims = new HashMap<String,Integer>();
        claims.put("admin_username",username);
        String subject = "admin";
        String token = null;
        try {
            //该token过期时间为12h
            token = JwtUtil.createToken(claims, subject);
        } catch (Exception e) {
            throw new RuntimeException("创建Token失败");
        }

        System.out.println("token:"+token);
        return token;*/
        return  null;
    }

    @Override
    public User selectByName(String userName) {
        User user = userMapper.selectByName(userName);

        return user;
    }


}
