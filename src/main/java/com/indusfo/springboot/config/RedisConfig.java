package com.indusfo.springboootdemo_user.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


/**
 * @ClassName RedisConfig
 * @Description //TDD
 * @Author hewb
 * @Date 2019/4/24 16:02
 **/
@Configuration
public class RedisConfig {
        @Bean
        public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();

            //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
            redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
            redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

            //使用StringRedisSerializer来序列化和反序列化redis的ke
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setHashKeySerializer(new StringRedisSerializer());

            //开启事务
            redisTemplate.setEnableTransactionSupport(true);

            redisTemplate.setConnectionFactory(redisConnectionFactory);

            return redisTemplate;
        }
    }



