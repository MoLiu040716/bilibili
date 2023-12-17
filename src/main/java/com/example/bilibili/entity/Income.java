package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Income {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int IncomeType;

    @Column(nullable = false)
    private double Money;

    @Column(nullable = false)
    private int Status;
}
