package com.github.springbootlearn.web;


import com.github.springbootlearn.model.Student;
import com.github.springbootlearn.model.User;
import com.github.springbootlearn.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * restful风格的controller测试
 */
@RestController
public class RestfulController {

    private static final String template = "Hello,%s!";

    private static final AtomicInteger atomicInteger = new AtomicInteger(1);

    @Autowired
    private Student stu;

    @Value("${user.username}")
    private String username;

    @Value("${user.sex}")
    private String sex;

    @Value("${user.address}")
    public String address;



    @RequestMapping("/greet")
    public User greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new User(atomicInteger.getAndIncrement(),String .format(template,name));
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo() {
        return username+sex+address;
    }


    @RequestMapping("/getStudent")
    public Student getStudent(){
        return stu;
    }
}
