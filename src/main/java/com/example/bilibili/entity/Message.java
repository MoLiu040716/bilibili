package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Title;

    @Column(nullable = false)
    private String Content;

    @Column(nullable = false)
    private Date PostTime;

    @Column(nullable = false)
    private int Total;

    @Column(nullable = false)
    private  int Click;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertising_position_id")
    private AdvertisingPosition advertisingPosition;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<UploadMassage> uploadMassages = new ArrayList<>();
}
