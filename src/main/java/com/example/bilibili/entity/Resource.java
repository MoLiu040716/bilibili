package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//资源表
@Data
@Entity
public class Resource {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    @Column(nullable = false)
    private Date CreatTime;

    @Column(nullable = false)
    private Date UpdateTime;

    private Date DeleteTime;

    //存储在某个文件夹中，需要某个URL对应
    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private String Title;

    //简介
    private String Introduction;

    //视频大小
    private int FileSize;

    //视频类型（mp4、mov）
    private String FileType;

    //观看总数
    @Column(nullable = false)
    private int ViewCount;

    //被点赞数
    @Column(nullable = false)
    private int LikeNum;

    //视频时长
    @Column(nullable = false)
    private int Duration;

    //创作者用户名
    @Column(nullable = false)
    private String UploaderName;

    //弹幕总数
    @Column(nullable = false)
    private int BulletCommentNum;

    //被收藏数
    @Column(nullable = false)
    private int CollectionNum;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private Upload upload;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    private List<BrowsingHistory> browsingHistories = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    private List<BulletComments> bulletComments = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    private List<Checks> checks = new ArrayList<>();
}
