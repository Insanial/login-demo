package com.demo.login_demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.demo.login_demo.entity.User;

@Mapper
public interface UserDao {

    //简单封装一个查询用户的方法
    User findByName(String name);
}
