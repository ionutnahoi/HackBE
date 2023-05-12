package com.hacktm.hackbe.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Accounts {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String email, password;
    @OneToMany(mappedBy = "account_who_wants_to_access", cascade = CascadeType.ALL)
    private List<Role> roles_who_can_access = new ArrayList<>();
    @OneToMany(mappedBy = "accounts_who_can_accept", cascade = CascadeType.ALL)
    private List<Role> roles_who_can_accept = new ArrayList<>();
}