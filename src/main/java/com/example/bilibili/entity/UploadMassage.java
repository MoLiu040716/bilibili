package com.example.bilibili.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class UploadMassage {
    @Id
    private int message_id;

    @Id
    private int upload_id;

    @Column(nullable = false)
    private int Status = 0;

    @Column(nullable = false)
    private Date ReadTime;
}
