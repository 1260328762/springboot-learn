package com.github.springbootlearn.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLOutput;


@Configuration
@PropertySource(value = {"classpath:userinfo.properties"})
public class UserInfo {

    @Value("${user.username}")
    private String userName;
    @Value("${user.sex}")
    private String sex;
    @Value("${user.address}")
    private String address;



    public void printValue(){
        System.out.println(userName+sex+address);
    }
}
