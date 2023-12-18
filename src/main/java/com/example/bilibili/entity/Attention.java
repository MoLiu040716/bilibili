package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//关注表
@Data
@Entity
public class Attention {
    @Id
    private int upload_id;

    @Id
    private int user_id;

    @Column(nullable = false)
    private Date CreatTime;

    private Date UpdateTime;

    //当前状态->关注 or 已取关
    @Column(nullable = false)
    private int Status;
}
