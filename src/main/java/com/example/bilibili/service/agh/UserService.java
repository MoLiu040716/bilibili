package com.example.bilibili.service.agh;

import com.example.bilibili.entity.User;

import java.util.List;

public interface UserService {
    // 用户登陆
    public User getUserInfoByName(String name);

    public List<User> getAllUsers();

    public int updateUserStatus(Integer id);

    public int updatePassword(String username, String oldPassword, String newPassword);

    public String getUserRoleInfo(String principal);

    public List<String> getUserPermissionInfo(String role);
}
