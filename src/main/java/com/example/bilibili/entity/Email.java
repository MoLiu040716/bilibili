package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//邮件，用于创作者和广告主交流
@Entity
@Data
public class Email {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    //邮件标题
    private String Title;

    //邮件内容
    private String Content;

    //发送时间
    @Column(nullable = false)
    private Date SendTime;

    //发送状态：0表示由创作者发给广告主，1表示由广告主发给创作者
    @Column(nullable = false)
    private int Status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private Upload upload;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertiser_id")
    private Advertiser advertiser;

}
