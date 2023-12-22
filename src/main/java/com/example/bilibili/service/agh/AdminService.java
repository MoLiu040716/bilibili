package com.example.bilibili.service.agh;

public interface AdminService {
    public int updatePassword(String username, String oldPassword, String newPassword);

    public int examineReportByReportIdAndManagerId(Integer ManagerId, Integer ReportId, String remark, Integer result);
}
