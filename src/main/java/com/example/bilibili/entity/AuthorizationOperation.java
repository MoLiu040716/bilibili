package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class AuthorizationOperation {
    @Id
    private int AuthorizationID;
    @Id
    private int OperationID;

    @Column(nullable = false)
    private Date CreatTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operator_id")
    private Manager manager;
}
