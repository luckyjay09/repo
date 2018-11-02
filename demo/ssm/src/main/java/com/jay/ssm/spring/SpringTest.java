package com.jay.ssm.spring;

import com.jay.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jws.soap.SOAPBinding;

//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@ContextConfiguration("classpath:applicationContext*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

    @Autowired
    private User user;

    @Autowired
    private UserService userService;

    @Test
    public void testUser() {
        System.out.println(user);
    }

    @Test
    public void testAop() {
        userService.getUser("啊哈哈哈哈", 9999);
    }
}
