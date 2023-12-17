package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date CreatTime;

    @Column(nullable = false)
    private Date DeleteTime;

    private int Department;

    private String Username;

    @Column(nullable = false)
    private String Password;

    @Column(nullable = false, unique = true)
    private String Phone;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private List<Report> reports = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private List<Checks> checks = new ArrayList<>();

}
