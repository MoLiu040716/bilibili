package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(nullable = false)
    private String URL;

    @Column(nullable = false)
    private String Title;

    private String Introduction;

    @Column(nullable = false)
    private int FileSize;

    @Column(nullable = false)
    private String FileType;

    @Column(nullable = false)
    private int ViewCount;

    @Column(nullable = false)
    private int LikeNum;

    @Column(nullable = false)
    private int Duration;

    @Column(nullable = false)
    private String UploaderName;

    @Column(nullable = false)
    private int BulletCommentNum;

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
