package com.jay.dubbo;

import com.jay.dubbo.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-web.xml");
        context.start();
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.getUser());
    }
}
