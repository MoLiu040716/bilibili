package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//邮件，用于创作者和广告主交流
@Entity
@Data
public class Email {
    @Id
    private int id;

    //邮件标题
    private String Title;

    //邮件内容
    private String Content;

    //发送时间
    @Column(nullable = false)
    private Date SendTime;

    //状态：已读、已发送（但未读）、已撤回（未读邮件才能撤回）
    @Column(nullable = false)
    private int Status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "upload_id")
    private Upload upload;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "advertiser_id")
    private Advertiser advertiser;

}
