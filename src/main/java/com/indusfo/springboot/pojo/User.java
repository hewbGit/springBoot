package com.indusfo.springboootdemo_user.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @ClassName User
 * @Description //TDD
 * @Author hewb
 * @Date 2019/4/10 13:14
 **/
@Data

public class User {
    private  Integer lUserId;
    private  String vcUserName;
    private  String vcUserCode;
    private  String lDataState;
    private  String vcUserPwd;
    private  String salt;

}
