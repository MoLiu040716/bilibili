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

    @Column(nullable = false)
    private int TargetType;

    @Column(nullable = false)
    private int TargetID;

    @Column(nullable = false)
    private Date CreatTime;

    private Date UpdateTime;

    @Column(nullable = false)
    private int Status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
