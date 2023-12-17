package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Advertiser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date CreatTime;

    private Date DeleteTime;

    private String UserName;

    private String Email;

    @Column(nullable = false)
    private String Password;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "advertiser_id")
    private List<AdvertisingPosition> advertisingPositions = new ArrayList<>();
}
