package com.example.bilibili.service.agh.impl;

import com.example.bilibili.mapper.agh.AdminMapper;
import com.example.bilibili.service.agh.AdminService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int examineReportByReportIdAndManagerId(Integer ManagerId, Integer ReportId, String remark, Integer result) {
        return adminMapper.examineReportByReportIdAndManagerId(ManagerId, ReportId, remark, result);
    }

    @Override
    public int freezeUser(String userId, Timestamp recoveryTime) {
        return adminMapper.freezeUser(userId, recoveryTime);
    }

    @Override
    public int freezeUploader(String uploaderId, Timestamp recoveryTime) {
        return adminMapper.freezeUploader(uploaderId, recoveryTime);
    }

    @Override
    public int resetPassword(Integer userId, String newPassword) {
        String encryptedNewPassword = ShiroMD5(newPassword);  // 新密码加密

        int result = adminMapper.resetPassword(userId, encryptedNewPassword);
        return result;
    }

    private String ShiroMD5(String password){
        // 对密码进行MD53次加盐加密
        SimpleHash simpleHash = new SimpleHash("MD5", password, "salt", 3);
        return simpleHash.toString();
    }
}
