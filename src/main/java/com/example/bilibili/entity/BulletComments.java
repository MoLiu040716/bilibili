package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

//弹幕表
@Getter
@Setter
@Entity
public class BulletComments {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    //弹幕内容
    @Column(nullable = false)
    private String Content;

    @Column(nullable = false)
    private Date CreatTime;

    @Column(nullable = false)
    private Date DeleteTime;

    //时间戳（弹幕是在视频的哪个时间点发送的）
    @Column(nullable = false)
    private int Timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
