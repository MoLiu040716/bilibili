package com.example.bilibili.service.agh.impl;

import com.example.bilibili.entity.User;
import com.example.bilibili.mapper.agh.UserMapper;
import com.example.bilibili.service.agh.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfoByName(String name) {
        return userMapper.getUserInfoByName(name);
    }
}
