package com.indusfo.springboootdemo_user.config;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName JWTInterceptor
 * @Description //TDD  自定义拦截器
 * @Author hewb
 * @Date 2019/4/15 16:13
 **/
@Component
public class JWTInterceptor implements HandlerInterceptor {
   /* @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        // 允许自定义请求头token(允许head跨域)
         response.setHeader("Access-Control-Allow-Headers",
                      "token, " +
                         "Accept, Origin, " +
                         "X-Requested-With, " +
                         "Content-Type, " +
                         "Last-Modified");

        //后台管理页面产生的token
        String token = request.getHeader("authorization");
        //判断是否过期
        Optional.ofNullable(token)
                .map(n -> {
                    try {
                        return JwtUtil.parseJWT(n);
                    } catch (Exception e) {
                        throw new RuntimeException("token不存在");
                    }
                });

        return true;
    }*/
   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // 允许跨域
       response.setHeader("Access-Control-Allow-Origin", "*");
       // 允许自定义请求头token(允许head跨域)
       response.setHeader("Access-Control-Allow-Headers",
               "token, " +
                       "Accept, Origin, " +
                       "X-Requested-With, " +
                       "Content-Type, " +
                       "Last-Modified");
       //后台管理页面产生的token
       String token = request.getHeader("authorization");
       System.out.println("JWTInterceptor" +"的token{"+token+"}");
             /*        response.setStatus(307);
                response.setHeader("Location","/captcha.jpg");*/
              //response.sendRedirect(request.getServletPath()+"captcha.jpg");
       return true;
   }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, @Nullable Exception ex) throws Exception {
    }
}
