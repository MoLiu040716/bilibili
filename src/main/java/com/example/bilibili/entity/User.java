package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //用户名，可为空
    private String userName;

    //密码
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String Phone;

    private String Email;

    //用户注册时间
    @Column(nullable = false)
    private Date creatTime;

    //用户注销时间
    private Date deleteTime;

    //用户当前状态->0已注销；1正常；2状态异常
    @Column(nullable = false)
    private int accountStatus;

    private Timestamp recoveryTime;

    private String Birthday;

    private int Sex;

    //头像
    private String profilePhoto;

    //用户关注人数
    @Column(nullable = false)
    private int attentionNum;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<BrowsingHistory> browsingHistories = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<Collection> collections = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<Favorite> favorites = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<Attention> attentions = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<AdvertiseClick> advertiseClicks = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<MyLike> myLikes = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private List<Report> reports = new ArrayList<>();
}
