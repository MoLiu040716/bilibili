package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.File;

//举报表
@Data
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    //目标类型（视频、评论、回复、弹幕）
    @Column(nullable = false)
    private int TargetType;

    //目标ID
    @Column(nullable = false)
    private int TargetID;

    //举报理由
    @Column(nullable = false)
    private String Reason;

    //举报类型（诈骗、违法等）
    @Column(nullable = false)
    private int ReportType;

    //附件
    private File Attachment;

    //处理结果（通过、不通过等）
    private int Result;

    //理由
    private String Remark;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
