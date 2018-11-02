package com.jay.ssm.service;

import com.jay.ssm.spring.User;

public class UserServiceImpl implements UserService {
    @Override
    public User getUser(String name, int age) {
        return new User(name, age);
    }
}
