package com.indusfo.springboootdemo_user.service;

import com.indusfo.springboootdemo_user.pojo.User;

import java.util.List;

public interface UserService {
     List<User> selectUser(User user);
     boolean loginUser(String userName,String password);
     String getToken(String userName);
     User selectByName(String userName);
}
