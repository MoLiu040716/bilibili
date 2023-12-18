package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//权限和操作的关联表
@Data
@Entity
public class AuthorizationOperation {
    @Id
    private int authorization_id;
    @Id
    private int operation_id;

    @Column(nullable = false)
    private Date CreatTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operator_id")
    private Manager manager;
}
