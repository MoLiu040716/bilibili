package com.example.bilibili.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class AdvertiseClick {
    @Id
    private int TakeAdvertiseID;
    @Id
    private int UserID;

    @Column(nullable = false)
    private Date ClickTime;

    @Column(nullable = false)
    private int ViewingDuration;
}
