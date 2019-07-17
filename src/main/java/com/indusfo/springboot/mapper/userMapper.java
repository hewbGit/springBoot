package com.indusfo.springboootdemo_user.mapper;
import com.indusfo.springboootdemo_user.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface userMapper {
    List<User> selectUser(User user);
    Integer loginUser(@Param("UserName") String userName,@Param("passWord") String passWord);

    User selectByName(@Param("userName") String userName);
}
