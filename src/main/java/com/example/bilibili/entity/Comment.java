package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

//评论
@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String UserName;

    //评论内容
    @Column(nullable = false)
    private String Content;

    //回复数
    @Column(nullable = false)
    private int ReplyNum = 0;

    //点赞数
    @Column(nullable = false)
    private int LikeNum = 0;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
