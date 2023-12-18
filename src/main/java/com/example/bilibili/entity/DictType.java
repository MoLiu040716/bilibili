package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//字典
@Data
@Entity
public class DictType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    //对应表格
    @Column(nullable = false)
    private String Form;

    //对应字段
    @Column(nullable = false)
    private String TheColumn;

    //当前状态->0已停用，1正在使用
    @Column(nullable = false)
    private int Status;

    @Column(nullable = false)
    private Date CreatTime;

    @Column(nullable = false)
    private Date UpdateTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dict_id")
    private List<DictData> dictData = new ArrayList<>();
}
