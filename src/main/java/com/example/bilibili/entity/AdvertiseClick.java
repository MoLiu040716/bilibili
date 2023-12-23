package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//广告点击日志表
@Data
@Entity
public class AdvertiseClick {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int take_advertise_id;

    @Column(nullable = false)
    private int user_id;

    @Column(nullable = false)
    private Date ClickTime;

    //点击后，在页面停留的时长
    @Column(nullable = false)
    private int ViewingDuration;
}
