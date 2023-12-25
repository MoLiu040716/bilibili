package com.example.bilibili.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//角色
@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String Name;

    //备注
    private String Remark;

    @Column(nullable = false)
    private Date CreatTime;

    private Date DeleteTime;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<RoleAssociation> roleAssociations = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<RoleAuthorization> roleAuthorizations = new ArrayList<>();

//    testOne
}
