package com.indusfo.springboootdemo_user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
    	// 添加请求参数，我们这里把token作为请求头部参数传入后端
		ParameterBuilder parameterBuilder = new ParameterBuilder();  
		List<Parameter> parameters = new ArrayList<Parameter>();  
		parameterBuilder.name("token").description("令牌")
			.modelRef(new ModelRef("string")).parameterType("header").required(false).build();  
		parameters.add(parameterBuilder.build());  
		return new Docket(DocumentationType.SWAGGER_2).groupName("swagger接口文档")
				.apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
				.build().globalOperationParameters(parameters);
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any()).build();

    }

    private ApiInfo apiInfo(){
    	/*return new ApiInfoBuilder()
    			.title("接口文档")
    			.description("接口测试")
    			.version("1.0")
				.termsOfServiceUrl("http://localhost:8082/swagger-ui.html")
    			.build();*/
        return new ApiInfoBuilder().build();
    }





}

