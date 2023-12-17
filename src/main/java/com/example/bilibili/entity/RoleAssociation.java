package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class RoleAssociation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int TargetType;

    @Column(nullable = false)
    private int TargetID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operator_id")
    private Manager manager;



}
