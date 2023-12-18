package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//审核资源表
//一个视频如果审核不成功，需要退回审核多次。此表记录每一次审核的相关信息。
@Data
@Entity
public class Checks {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date Time;

    //审核结果。0审核不通过，1审核通过
    @Column(nullable = false)
    private int Result;

    //备注，写明审核不通过原因
    @Column(nullable = false)
    private String Remark;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "resource_id")
    private Resource resource;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manager_id")
    private Manager manager;
}
