package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//广告主
@Data
@Entity
public class Advertiser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    //注册时间
    @Column(nullable = false)
    private Date CreatTime;

    //注销时间
    private Date DeleteTime;

    //用户当前状态->0已注销；1正常；2状态异常
    @Column(nullable = false)
    private int AccountStatus;

    private Timestamp RecoveryTime;

    private String UserName;

    private String Email;

    @Column(nullable = false)
    private String Password;

    private Timestamp RecoveryTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "advertiser_id")
    private List<AdvertisingPosition> advertisingPositions = new ArrayList<>();
}
