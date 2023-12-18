package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class AdvertisingPosition {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Title;

    @Column(nullable = false)
    private String Introduction;

    @Column(nullable = false)
    private Date BeginTime;

    private Date EndTime;

    @Column(nullable = false)
    private Double Reward;

    @Column(nullable = false)
    private int Process;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertiser_id")
    private Advertiser advertiser;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "advertising_position_id")
    private List<Message> messages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private List<TakeAdvertise> takeAdvertises = new ArrayList<>();
}
