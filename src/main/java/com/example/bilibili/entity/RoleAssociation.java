package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

//角色关联表
@Data
@Entity
public class RoleAssociation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    //目标类型（用户、创作者、广告商、管理员）
    @Column(nullable = false)
    private int TargetType;

    //目标ID
    @Column(nullable = false)
    private int TargetID;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operator_id")
    private Manager manager;



}
