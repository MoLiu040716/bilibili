package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

//收入表
@Data
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    //收入类型（实现创作者收入多元化）
    @Column(nullable = false)
    private int IncomeType;

    @Column(nullable = false)
    private double Money;

    //状态->已打款、未打款、未入账
    @Column(nullable = false)
    private int Status;
}
