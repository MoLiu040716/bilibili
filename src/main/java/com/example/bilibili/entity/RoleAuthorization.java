package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class RoleAuthorization {
    @Id
    private int role_id;
    @Id
    private int authorization_id;

    @Column(nullable = false)
    private Date CreatTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operator_id")
    private Manager manager;
}
