package com.example.bilibili.controller.agh;

import com.example.bilibili.service.agh.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@RequestMapping("/AdminController")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/updatePassword")
    public String updatePassword(String username, String oldPassword, String newPassword){
        int result = adminService.updatePassword(username, oldPassword, newPassword);
        if (result == 1){
            return "密码更新成功";
        } else if (result == 0){
            return "密码更新失败";
        } else {
            return "发生错误！";
        }
    }

    @PostMapping("/examineReportByReportIdAndManagerId")
    public String examineReportByReportIdAndManagerId(Integer ManagerId, Integer ReportId, String remark, Integer result){
        int res = adminService.examineReportByReportIdAndManagerId(ManagerId, ReportId, remark, result);
        if (res == 1){
            return "举报审核成功";
        } else {
            return "举报审核失败";
        }
    }

    @PostMapping("/freezeUser")
    public String freezeUser(String userId, Timestamp recoveryTime){
        int result = adminService.freezeUser(userId, recoveryTime);
        if (result == 1){
            return "账号冻结成功，解冻时间为" + recoveryTime;
        } else {
            return "账号冻结失败";
        }
    }

    @PostMapping("/freezeUploader")
    public String freezeUploader(String uploaderId, Timestamp recoveryTime){
        int result = adminService.freezeUploader(uploaderId, recoveryTime);
        if (result == 1){
            return "账号冻结成功，解冻时间为" + recoveryTime;
        } else {
            return "账号冻结失败";
        }
    }
}
