package com.example.bilibili.service.cj.Impl;

import com.example.bilibili.entity.User;
import com.example.bilibili.mapper.cj.UserMapper;
import com.example.bilibili.service.cj.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public String registerService(User user) {
        User userR = userMapper.selectByUserNameAndPassword(user.getUserName(), user.getPassword());
        if (userR == null) {
            if ("".equals(user.getPassword())) {
                return "请输入密码";
            } else if ("".equals(user.getUserName())) {
                return "请输入用户昵称";
            } else {
                userMapper.insert(user);
                return "SUCCESS";
            }
        }
        return "用户以存在";

    }


}
