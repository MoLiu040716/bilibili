package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//创作者
@Data
@Entity
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //注册时间
    @Column(nullable = false)
    private Date creatTime;

    //注销时间
    private Date deleteTime;

    //用户当前状态->0已注销；1正常；2状态异常
    @Column(nullable = false)
    private int accountStatus;

    private Timestamp recoveryTime;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String emailAddress;

    //被关注数（粉丝数）
    @Column(nullable = false)
    private int fansNum;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<Resource> ResourceList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<Attention> attentions = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<Income> incomes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<UploadMassage> uploadMassages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<TakeAdvertise> takeAdvertises = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<Email> emails = new ArrayList<>();
}
