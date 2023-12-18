package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//收藏夹
@Data
@Entity
public class Collection {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date CreatTime;

    private Date DeleteTime;

    @Column(nullable = false)
    private String name;

    //收藏夹中，总记录条数
    @Column(nullable = false)
    private int CollectionNum = 0;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "collection_id")
    private List<Favorite> favorites = new ArrayList<>();

}
