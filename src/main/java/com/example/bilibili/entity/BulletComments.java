package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class BulletComments {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Content;

    @Column(nullable = false)
    private Date CreatTime;

    @Column(nullable = false)
    private Date DeleteTime;

    @Column(nullable = false)
    private int Timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
