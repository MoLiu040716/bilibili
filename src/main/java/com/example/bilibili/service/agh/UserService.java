package com.example.bilibili.service.agh;

import com.example.bilibili.entity.User;

public interface UserService {
    // 用户登陆
    public User getUserInfoByName(String name);
}
