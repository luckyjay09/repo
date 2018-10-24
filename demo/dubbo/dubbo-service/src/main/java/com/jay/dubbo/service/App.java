package com.jay.dubbo.service;

import com.alibaba.dubbo.container.Main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-service.xml");
        context.start();
        System.in.read();
    }
}
