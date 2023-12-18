package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//标签关联表
@Data
@Entity
public class LabelAssociation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    //目标类型（关联用户、关联资源）
    @Column(nullable = false)
    private int TargetType;

    //目标ID
    @Column(nullable = false)
    private int TargetID;

    @Column(nullable = false)
    private Date CreatTime;

    @Column(nullable = false)
    private Date DeleteTime;
}
