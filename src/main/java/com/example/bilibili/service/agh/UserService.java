package com.example.bilibili.service.agh;

import com.example.bilibili.entity.User;

import java.util.List;

public interface UserService {
    // 用户登陆
    public User getUserInfoByName(String name);

    public List<User> getAllUsers();
}
