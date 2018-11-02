package com.jay.ssm.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class BeanTest {

    @Test
    public void getUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
