package com.example.bilibili.util;

import com.example.bilibili.entity.Upload;
import com.example.bilibili.entity.User;
import com.example.bilibili.service.agh.UploaderService;
import com.example.bilibili.service.agh.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class AccountScheduler {
    @Autowired
    private UserService userService;

    @Autowired
    private UploaderService uploaderService;

    @Scheduled(fixedRate = 5000) // 每隔5秒执行一次
    public void checkRecoveryTime(){
        List<User> users = userService.getAllUsers();
        List<Upload> uploaders = uploaderService.getAllUploaders();

        LocalDateTime currentDateTime = LocalDateTime.now();

        for (User user : users){
            Optional.ofNullable(user.getRecoveryTime())
                    .map(Timestamp::toLocalDateTime)
                    .ifPresent(recoveryTime -> {
                        if (currentDateTime.isAfter(recoveryTime)) {
                            // 账号解冻，将 recoveryTime 设置为 null
                            user.setRecoveryTime(null);
                            userService.updateUserStatus(user.getId());
                        }
                    });
        }

        for (Upload uploader : uploaders){
            Optional.ofNullable(uploader.getRecoveryTime())
                    .map(Timestamp::toLocalDateTime)
                    .ifPresent(recoveryTime -> {
                        if (currentDateTime.isAfter(recoveryTime)) {
                            // 账号解冻，将 recoveryTime 设置为 null
                            uploader.setRecoveryTime(null);
                            uploaderService.updateUploaderStatus(uploader.getId());
                        }
                    });
        }

    }
}
