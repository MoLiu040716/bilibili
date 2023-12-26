package com.example.bilibili.service.agh.impl;

import com.example.bilibili.entity.User;
import com.example.bilibili.mapper.agh.UserMapper;
import com.example.bilibili.service.agh.UserService;
import com.example.bilibili.util.BusinessException;
import jakarta.transaction.Transactional;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
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

        return userMapper.updatePassword(username, encryptedOldPassword, encryptedNewPassword);
    }

    private String ShiroMD5(String password) {
        // 对密码进行MD53次加盐加密
        SimpleHash simpleHash = new SimpleHash("MD5", password, "salt", 3);
        return simpleHash.toString();
    }

    @Override
    public String getUserRoleInfo(String principal) {
        return userMapper.getUserRoleInfo(principal);
    }

    @Override
    public List<String> getUserPermissionInfo(String role) {
        return userMapper.getUserPermissionInfo(role);
    }

    @Override
    public Boolean register(String phone, String email, String password, String userName) {
        User user = new User();
        user.setPhone(phone);
        user.setCreatTime(new Date());
        user.setEmail(email);
        user.setUserName(userName);
        user.setPassword(String.valueOf(new Md5Hash(password)));
        user.setCreatTime(new Date());
        user.setAccountStatus(1);
        if (userMapper.selectUserByUserName(user.getUserName()) != null) {
            throw new BusinessException("用户名重复");
        }
        if (userMapper.selectUserByEmail(user.getEmail()) != null) {
            throw new BusinessException("邮箱已被注册");
        }
        if (userMapper.selectUserPhone(user.getPhone()) != null) {
            throw new BusinessException("手机号已被注册");
        }
        return userMapper.insert(user) > 0;
    }

    @Override
    public Integer save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean updateUserInfoById(int id, String email, String userName, String phone, String birthday, int sex) {
        User result = userMapper.selectById(id);
        if (result == null || result.getAccountStatus() == 0) {
            throw new BusinessException("用户数据不存在");
        }
//
        int rows = userMapper.updateUserInfo(id, email, userName, phone,birthday, sex);
        if (rows != 1) {
            throw new BusinessException("更新用户信息异常");
        }
        if (userMapper.selectUserByUserName(result.getUserName()) != null) {
            throw new BusinessException("用户名重复");
        }
        if (userMapper.selectUserByEmail(result.getEmail()) != null) {
            throw new BusinessException("邮箱重复");
        }
        if (userMapper.selectUserPhone(result.getPhone()) != null) {
            throw new BusinessException("手机号重复");
        }
        return true;
    }


    @Override
    public void updateAvatarById(int id, String filePhoto) {
        User result = userMapper.selectById(id);
        if (result == null || result.getAccountStatus() == 0) {
            throw new BusinessException("用户数据不存在");
        }
        int rows = userMapper.updateAvatar(id, filePhoto);
        if (rows != 1) {
            throw new BusinessException("更新用户头像异常");
        }
    }

    @Override
    public Boolean getAvatarById(int id) {
        User user = userMapper.selectById(id);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }

}
