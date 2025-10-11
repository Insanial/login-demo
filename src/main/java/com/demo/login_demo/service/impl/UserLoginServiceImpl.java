package com.demo.login_demo.service.impl;

import org.springframework.stereotype.Service;

import com.demo.login_demo.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {
    public String hello(){
        return "Hello World";
    }
}
