package com.example.bilibili.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

//浏览记录
@Data
@Entity
public class BrowsingHistory {
    @Id
    private int user_id;
    @Id
    private int resource_id;

    //浏览时间
    @Column(nullable = false)
    private Date BrowsingTime;

    //浏览时长
    @Column(nullable = false)
    private Date ViewingDuration;
}
