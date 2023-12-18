package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class MyLike {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    //目标类型（视频、评论、回复、弹幕）
    @Column(nullable = false)
    private int TargetType;

    //目标ID
    @Column(nullable = false)
    private int TargetID;

    @Column(nullable = false)
    private Date CreatTime;

    private Date UpdateTime;

    //当前状态（已下线、正常）
    @Column(nullable = false)
    private int Status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
