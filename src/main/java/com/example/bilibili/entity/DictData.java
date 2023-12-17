package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DictData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int Sort;

    @Column(nullable = false)
    private int Value;

    @Column(nullable = false)
    private String Label;
}
