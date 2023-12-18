package com.example.bilibili.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class BrowsingHistory {
    @Id
    private int user_id;
    @Id
    private int resource_id;

    @Column(nullable = false)
    private Date BrowsingTime;

    @Column(nullable = false)
    private Date ViewingDuration;
}
