package com.example.bilibili.controller.agh;

import com.example.bilibili.service.agh.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
