package com.github.springbootlearn.test;

import com.github.springbootlearn.model.User;
import com.github.springbootlearn.util.JedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private JedisUtil jedisUtil;

    @Test
    public void testSet(){
        User user = new User();
        user.setId(1);
        user.setName("chenliang");
        boolean user1 = jedisUtil.set("user", user, 360);
        System.out.println(user1);
    }

    @Test
    public void testGet(){
        User user = (User) jedisUtil.get("user");
        System.out.println(user.getId());
        System.out.println(user.getName());
    }



}
