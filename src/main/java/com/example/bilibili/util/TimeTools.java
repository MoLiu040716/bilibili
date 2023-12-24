package com.example.bilibili.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeTools {
    public static int getActivityProcess(String BeginTime, String EndTime) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        BeginTime=TimeTools.firstProgressForDate(BeginTime);
//        EndTime=TimeTools.firstProgressForDate(EndTime);
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

//    public static String firstProgressForDate(String dateString) {
//        String[] parts = dateString.split("\\s+");
//        if (parts.length >= 6) {
//            dateString = String.join(" ", parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
//        }
//        SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss", Locale.ENGLISH);
//        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//
//        try {
//            Date date = inputFormat.parse(dateString);
//            return outputFormat.format(date);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            // 处理解析异常
//        }
//        return ""; // 如果发生异常，返回空字符串或者其他默认值
//    }
}
