package com.example.bilibili.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

//广告点击日志表
@Data
@Entity
public class AdvertiseClick {
    @Id
    private int take_advertise_id;
    @Id
    private int user_id;
    @Id
    private Date ClickTime;

    //点击后，在页面停留的时长
    @Column(nullable = false)
    private int ViewingDuration;
}
