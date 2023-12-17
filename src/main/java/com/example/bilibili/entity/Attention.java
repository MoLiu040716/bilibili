package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Attention {
    @Id
    private int upload_id;

    @Id
    private int user_id;

    @Column(nullable = false)
    private Date CreatTime;

    private Date UpdateTime;

    @Column(nullable = false)
    private int Status;
}
