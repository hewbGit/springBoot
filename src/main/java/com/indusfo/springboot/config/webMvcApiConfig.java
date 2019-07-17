package com.indusfo.springboootdemo_user.config;


import javafx.application.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName webApiConfig
 * @Description //TDD 拦截器配置
 * @Author hewb
 * @Date 2019/4/22 14:26
 **/
/*@Configuration
@ComponentScan(basePackageClasses = Application.class, useDefaultFilters = true)*/
public class webMvcApiConfig extends WebMvcConfigurationSupport {

    /**
     *
     * 功能描述:
     *  配置静态资源,避免静态资源请求被拦截
     * @auther: Tt(yehuawei)
     * @date:
     * @param:
     * @return:
     */
 /*   public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }

    public void addInterceptors(InterceptorRegistry registry) {
     //   registry.addInterceptor(myInterceptor).addPathPatterns("/*");
        super.addInterceptors(registry);
    }*/

    /**
     * @return void
     * @Author hewb
     * @Description //TODO 添加拦截器  和配置拦截路径
     * @Date 2019/5/6 12:55
     * @Param [registry]
     */
/*    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        System.out.println("实例化拦截器和配置不进入拦截器的方法");
        //添加实例化拦截器
        registry.addInterceptor(new JWTInterceptor()).
                //配置拦截器的拦截路径
                        addPathPatterns("/**").
                //配置不进入拦截器的方法 ,多个可以往后面追加 用逗号分隔
                        excludePathPatterns("/testLogin", "/doc.html", "/webjars/**");
        super.addInterceptors(registry);
    }

    *//**
     * @return void
     * @Author hewb
     * @Description //TODO 配置静态资源放行  避免静态资源被拦截
     * @Date 2019/5/6 13:08
     * @Param [registry]
     *//*
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("配置静态资源放行");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    *//**
     * @return void
     * @Author hewb
     * @Description //TODO 视图配置
     * @Date 2019/5/6 13:15
     * @Param [registry]
     *//*
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/", ".jsp");
        super.configureViewResolvers(registry);
    }*/
}
