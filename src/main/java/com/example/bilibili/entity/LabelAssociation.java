package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class LabelAssociation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int TargetType;

    @Column(nullable = false)
    private int TargetID;

    @Column(nullable = false)
    private Date CreatTime;

    @Column(nullable = false)
    private Date DeleteTime;
}
