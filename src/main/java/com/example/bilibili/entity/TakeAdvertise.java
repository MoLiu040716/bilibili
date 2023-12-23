package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//接广告表
@Data
@Entity
public class TakeAdvertise {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date TakeTime;

    //进程（待开始、已发布广告、合作结束等）
    @Column(nullable = false)
    private int Progress;

    //广告曝光次数
    @Column(nullable = false)
    private int ImpressionNum;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "take_advertise_id")
    private List<AdvertiseClick> advertiseClicks = new ArrayList<>();
}
