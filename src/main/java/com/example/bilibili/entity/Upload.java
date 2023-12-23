package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//创作者
@Data
@Entity
public class Upload {
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

    private Date RecoveryTime;

    @Column(nullable = false)
    private String UserName;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false)
    private String Phone;

    @Column(nullable = false)
    private String EMail;

    //被关注数（粉丝数）
    @Column(nullable = false)
    private int FansNum;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
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
}
