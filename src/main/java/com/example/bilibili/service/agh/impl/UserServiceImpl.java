package com.example.bilibili.service.agh.impl;

import com.example.bilibili.entity.User;
import com.example.bilibili.mapper.agh.UserMapper;
import com.example.bilibili.service.agh.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserInfoByName(String name) {
        return userMapper.getUserInfoByName(name);
    }

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public int updateUserStatus(Integer id) {
        return userMapper.updateUserStatus(id);
    }

    @Override
    public int updatePassword(String username, String oldPassword, String newPassword) {
        String encryptedOldPassword = ShiroMD5(oldPassword);  // 旧密码加密
        String encryptedNewPassword = ShiroMD5(newPassword);  // 新密码加密

        int result = userMapper.updatePassword(username, encryptedOldPassword, encryptedNewPassword);
        return result;
    }

    private String ShiroMD5(String password){
        // 对密码进行MD53次加盐加密
        SimpleHash simpleHash = new SimpleHash("MD5", password, "salt", 3);
        return simpleHash.toString();
    }
}
