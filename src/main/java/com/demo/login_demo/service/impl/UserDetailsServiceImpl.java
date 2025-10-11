package com.demo.login_demo.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.login_demo.dao.UserDao;
import com.demo.login_demo.entity.User;

import jakarta.annotation.Resource;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username){
        // 1.从MySql数据库中查询用户信息
        User user = userDao.findByName(username);

        //TODO 2.如果用户不存在，抛出异常
        if(user == null){
            throw new UsernameNotFoundException("用户不存在: " + username);
        }
        //TODO 3.如果用户存在，将User对象转成UserDetails对象并返回
        return new UserDetailsImpl(user);
    }
}
