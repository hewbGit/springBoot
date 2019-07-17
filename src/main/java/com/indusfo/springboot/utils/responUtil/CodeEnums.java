package com.indusfo.springboootdemo_user.utils.responUtil;


/**
 * @Author hewb
 * @Description //TODO 响应和状态码
 * @Date 2019/4/11 12:44
 * @Param
 * @return
 */
public enum CodeEnums {
    /**
     * 响应状态码和说明
     */
    SUCCESS(1, "成功！"),
    FAIL(0, "服务器异常"),
    SERVICE_RETRY(504, "服务器连接失败"),
    SERVICE_VALIDATE(505, "验证码发送太频繁"),
    TOKEN_EXPIRED(506, "token失效"),
    TOKEN_REPEAT(507, "异地登录");
    /**
     * 响应状态码
     */
    private final int code;

    /**
     * 响应提示s
     */
    private final String msg;

    CodeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}




