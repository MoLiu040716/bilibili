package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class DictType {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Form;

    @Column(nullable = false)
    private String TheColumn;

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
