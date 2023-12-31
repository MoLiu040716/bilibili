package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

//回复表
@Data
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String UserName;

    @Column(nullable = false)
    private String Content;

    //被点赞数
    @Column(nullable = false)
    private int LikeNum;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private Reply reply;
}
