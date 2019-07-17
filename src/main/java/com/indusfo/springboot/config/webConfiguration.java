package com.indusfo.springboootdemo_user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName webConfiguration
 * @Description //TDD  跨域请求配置
 * @Author hewb
 * @Date 2019/4/15 16:10
 **/
@Configuration
public class webConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //允许跨域访问的请求
        registry.addMapping("/**")
                //跨域请求的可以请求的内容
                .allowedOrigins("*")
                //允许的请求方式
                .allowedMethods("POST", "GET", "PUT")
                //预检间隔时间
                .maxAge(180000)
                //允许的头部设置
                .allowedHeaders("Access-Control-Allow-Headers",
                        "token, " +
                                "Accept, Origin, " +
                                "X-Requested-With, " +
                                "Content-Type, " +
                                "Last-Modified")
                //设置发送cookie
                .allowCredentials(true);

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
       // super.addResourceHandlers(registry);
    }


}
