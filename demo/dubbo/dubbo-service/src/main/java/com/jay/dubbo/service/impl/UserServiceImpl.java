package com.jay.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jay.dubbo.pojo.User;
import com.jay.dubbo.service.UserService;

//@Service
public class UserServiceImpl implements UserService {


    @Override
    public User getUser() {
        return new User("hehe", 2343);
    }
}
