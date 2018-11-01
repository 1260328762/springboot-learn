package com.github.springbootlearn.configuration;

import com.github.springbootlearn.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.Jedis;

/**
 * 自定义配置类
 */
@Configuration
@PropertySource("classpath:redis.properties")
public class StudentConfiguation {

    @Value("${redis.url}")
    private String redisUrl;

    @Value("${redis.port}")
    private Integer redisPort;

    @Value("${redis.password}")
    private String password;


    @Bean
    public Student getStudent(){
        Student stu = new Student();
        stu.setId(1);
        stu.setName("小明");
        return stu;
    }

    // @Bean
    // public Jedis getJedis(){
    //     Jedis jedis = new Jedis(redisUrl,redisPort);
    //     jedis.auth(password);
    //
    //     return jedis;
    // }

}
