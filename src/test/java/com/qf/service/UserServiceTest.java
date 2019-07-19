package com.qf.service;

import com.qf.AcTests;
import com.qf.pojo.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

public class UserServiceTest extends AcTests {

    @Autowired
    private UserService userService;

    @Test
    public void checkUsername() {
        Integer count = userService.checkUsername("admin");

        System.out.println(count);
    }

    @Test
    @Transactional
    public void register(){
        User user = new User();
        user.setUsername("xxxxx");
        user.setPassword("xxxxx");
        user.setPhone("11111111111");

        Integer count = userService.register(user);

        assertEquals(new Integer(1),count);
    }


    @Test
    public void login(){
        User user = userService.login("admin", "admin");
        System.out.println(new Md5Hash("admin",null,1024).toString());
        System.err.println(user);
    }
}