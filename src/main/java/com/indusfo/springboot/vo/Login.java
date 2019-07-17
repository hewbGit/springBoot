package com.indusfo.springboootdemo_user.vo;

/**
 * @ClassName Login
 * @Description //TDD登陆封装类
 * @Author hewb
 * @Date 2019/4/18 13:45
 **/
public class Login {
    private  String userName;
    private  String passWord;
    private  String captcha;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String password) {
        this.passWord = password;
    }

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }
}
