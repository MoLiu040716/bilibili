package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.File;

@Data
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int TargetType;

    @Column(nullable = false)
    private int TargetID;

    @Column(nullable = false)
    private String Reason;

    @Column(nullable = false)
    private int ReportType;

    private File Attachment;

    @Column(nullable = false)
    private int Result;

    @Column(nullable = false)
    private String Remark;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
