package com.qf.mapper;

import com.qf.AcTests;
import com.qf.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

public class UserMapperTest extends AcTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void findCountByUsername() {

        Integer count = userMapper.findCountByUsername("admin123");

        System.err.println(count);

    }

    @Test
    @Transactional
    public void save(){
        User user = new User();
        user.setUsername("xxxxx");
        user.setPassword("xxxxx");
        user.setPhone("11111111111");

        Integer count = userMapper.save(user);

        assertEquals(new Integer(1),count);
    }


    @Test
    public void findByUsername(){
        User user = userMapper.findByUsername("admin");

        System.err.println(user);
    }
}