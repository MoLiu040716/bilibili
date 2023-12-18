package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

//字典数据
@Data
@Entity
public class DictData {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    //该类型字段排序顺序
    @Column(nullable = false)
    private int Sort;

    //字段值
    @Column(nullable = false)
    private int Value;

    //标签
    @Column(nullable = false)
    private String Label;
}
