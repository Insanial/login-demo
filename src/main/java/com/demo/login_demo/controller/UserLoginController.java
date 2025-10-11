package com.demo.login_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.login_demo.service.UserLoginService;

import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class UserLoginController {
    
    @Resource
    private UserLoginService userLoginService;

    @GetMapping("/hello")
    public String hello() {
        return userLoginService.hello();
    }
    
}
