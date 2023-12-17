package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Upload {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date CreatTime;

    private Date DeleteTime;

    @Column(nullable = false)
    private String UserName;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false)
    private String Phone;

    @Column(nullable = false)
    private String EMail;

    @Column(nullable = false)
    private int FansNum;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<Resource> ResourceList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<Attention> attentions = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<Income> incomes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private List<UploadMassage> uploadMassages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id")
    private List<TakeAdvertise> takeAdvertises = new ArrayList<>();
}
