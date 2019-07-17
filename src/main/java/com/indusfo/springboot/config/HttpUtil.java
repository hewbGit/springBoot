package com.indusfo.springboootdemo_user.config;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName HttpUtil
 * @Description //TDD
 * @Author hewb
 * @Date 2019/4/16 15:26
 **/
public class HttpUtil {
    public  static HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }


    public  static  void  print(HttpServletResponse response,int code,String msg){
        response.setContentType("application/json; charset=utf-8");
       /* HttpResult result = HttpResult.error(code, msg);
        String json = JSONObject.toJSONString(result);
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();*/
    }

    public static void main(String[] args) {
        HttpServletRequest httpServletRequest = HttpUtil.getHttpServletRequest();
        System.out.println(httpServletRequest.getAuthType());
    }
}
