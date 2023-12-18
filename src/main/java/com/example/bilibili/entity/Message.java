package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//站内信
@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Title;

    @Column(nullable = false)
    private String Content;

    //站内信推送时间
    @Column(nullable = false)
    private Date PostTime;

    //记录收件人总人数，根据点击数计算点击率
    @Column(nullable = false)
    private int Total;

    //记录点击数
    @Column(nullable = false)
    private  int Click;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertising_position_id")
    private AdvertisingPosition advertisingPosition;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<UploadMassage> uploadMassages = new ArrayList<>();
}
