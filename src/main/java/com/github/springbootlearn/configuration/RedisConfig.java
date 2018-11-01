package com.github.springbootlearn.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

    @Value("${redis.maxTotal}")
    private int maxTotal;

    @Value("${redis.url}")
    private String redisUrl;

    @Value("${redis.port}")
    private int redisPort;

    @Value("${redis.password}")
    private String redisPassword;


    /**
     * 连接池配置
     * @return
     */
    @Bean
    public JedisPoolConfig getJedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(maxTotal);
        return config;
    }

    /**
     * 连接工厂配置
     * @return
     */
    @Bean
    public JedisConnectionFactory getJedisConnectionFactory(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setPoolConfig(getJedisPoolConfig());
        factory.setHostName(redisUrl);
        factory.setPort(redisPort);
        factory.setPassword(redisPassword);
        return factory;
    }


    /**
     * redis模板配置
     * @return
     */
    @Bean
    public RedisTemplate getRedisTemplate(){
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(getJedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setEnableTransactionSupport(true);

        return template;
    }



}
