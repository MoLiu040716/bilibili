package com.example.bilibili.service.agh;

import java.sql.Timestamp;

public interface AdminService {
    public int examineReportByReportIdAndManagerId(Integer ManagerId, Integer ReportId, String remark, Integer result);

    public int freezeUser(String userId, Timestamp recoveryTime);

    public int freezeUploader(String uploaderId, Timestamp recoveryTime);

    public int resetPassword(Integer userId, String newPassword);
}
