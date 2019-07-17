package com.indusfo.springboootdemo_user.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author hewb
 * @Description //TODO 验证码配置
 * @Date 2019/4/18 10:15
 * @Param
 * @return
 */
@Configuration
public class kaptchaConfig {

    @Bean
    public DefaultKaptcha producer() {
        Properties properties = new Properties();
//        //设置图片边框 默认yes
//        properties.put("kaptcha.border", "yes");
//        //设置边框颜色默认black
//        properties.put("kaptcha.border.color","black");
//        properties.put("kaptcha.textproducer.font.color", "black");
//        //设置间隔
//        properties.put("kaptcha.textproducer.char.space", "5");
//        //设置字体大小
//        properties.put("kaptcha.textproducer.font.size", "40");
//        properties.put("kaptcha.noise.imp", "priv.kerlomz.kaptcha.impl.FishEyeGimpy");
        //边框
        properties.put("kaptcha.border", "yes");
        //边框为绿色
        properties.put("kaptcha.border.color", "green");
        //图片宽度
        properties.put("kaptcha.image.width", "200");
        //高度
        properties.put("kaptcha.image.height", "50");
        //字符数量
        properties.put("kaptcha.textproducer.char.length", "5");
        //字体大小
        properties.put("kaptcha.textproducer.font.size", "40");
        //字符间隔
        properties.put("kaptcha.textproducer.char.space", "2");
        //噪声颜色
        properties.put("kaptcha.noise.color", "black");

        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
