package com.example.bilibili.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

//创作者是否已读记录表
@Data
@Entity
public class UploadMassage {
    @Id
    private int message_id;

    @Id
    private int upload_id;

    //是否已读
    @Column(nullable = false)
    private int Status = 0;

    //已读时间
    @Column(nullable = false)
    private Date ReadTime;
}
