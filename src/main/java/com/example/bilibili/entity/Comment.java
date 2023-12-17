package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String UserName;

    @Column(nullable = false)
    private String Content;

    @Column(nullable = false)
    private int ReplyNum = 0;

    @Column(nullable = false)
    private int LikeNum = 0;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    private Resource resource;
}
