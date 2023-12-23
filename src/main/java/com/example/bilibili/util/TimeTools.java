package com.example.bilibili.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTools {
    public static int getActivityProcess(String BeginTime, String EndTime) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date bgTime = dateFormat.parse(BeginTime);
        Date edTime = dateFormat.parse(EndTime);

        Date currentTime = new Date(); // 获取当前时间

        if (currentTime.before(bgTime)) {
            // 活动还未开始
            return 0;
        } else if (currentTime.after(edTime)) {
            // 活动已经结束
            return 2;
        } else {
            // 活动正在进行中
            return 1;
        }
    }

    //重载方法
    public static int getActivityProcess(Date bgTime, Date edTime) {
        Date currentTime = new Date();
        if (currentTime.before(bgTime)) {
            return 0;
        } else if (currentTime.after(edTime)) {
            return 2;
        } else {
            return 1;
        }
    }

}
