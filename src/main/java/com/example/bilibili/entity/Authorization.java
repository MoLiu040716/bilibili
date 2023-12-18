package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//权限
@Data
@Entity
public class Authorization {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Name;

    //权限备注
    private String Remark;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "authorization_id")
    private List<RoleAuthorization> roleAuthorizations = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "authorization_id")
    private List<AuthorizationOperation> authorizationOperations = new ArrayList<>();
}
