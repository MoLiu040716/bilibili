package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//广告位ID
@Data
@Entity
public class AdvertisingPosition {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Title;

    @Column(nullable = false)
    private String Introduction;

    //广告开始招创作者的日期
    @Column(nullable = false)
    private Date BeginTime;

    private Date EndTime;

    //报酬情况
    @Column(nullable = false)
    private Double Reward;

    //项目当前进展情况->0筹备中；1已开始；2已结束；3状态异常（被举报）
    @Column(nullable = false)
    private int Process;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertiser_id")
    private Advertiser advertiser;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "advertising_position_id")
    private List<Message> messages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private List<TakeAdvertise> takeAdvertises = new ArrayList<>();
}
