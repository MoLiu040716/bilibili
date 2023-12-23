package com.example.bilibili.controller.agh;

import com.example.bilibili.service.agh.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/AdminController")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/examineReportByReportIdAndManagerId")
    public String examineReportByReportIdAndManagerId(Integer ManagerId, Integer ReportId, String remark, Integer result){
        int res = adminService.examineReportByReportIdAndManagerId(ManagerId, ReportId, remark, result);
        if (res == 1){
            return "举报审核成功";
        } else {
            return "举报审核失败";
        }
    }

    @GetMapping("/freezeUser")
    public String freezeUser(@RequestParam String userId,@RequestParam Timestamp recoveryTime){
        int result = adminService.freezeUser(userId, recoveryTime);
        if (result == 1){
            return "账号冻结成功，解冻时间为" + recoveryTime;
        } else {
            return "账号冻结失败";
        }
    }

    @GetMapping("/freezeUploader")
    public String freezeUploader(@RequestParam String uploaderId,@RequestParam Timestamp recoveryTime){
        System.out.println(uploaderId);
        int result = adminService.freezeUploader(uploaderId, recoveryTime);
        if (result == 1){
            return "账号冻结成功，解冻时间为" + recoveryTime;
        } else {
            return "账号冻结失败";
        }
    }

    @GetMapping("/resetPassword")
    public String resetPassword(Integer userId, String newPassword){
        int result = adminService.resetPassword(userId, newPassword);
        if (result == 1){
            return "密码重置成功";
        } else {
            return "密码重置失败";
        }
    }
}
