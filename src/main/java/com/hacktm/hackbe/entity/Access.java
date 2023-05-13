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
public class Access {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @OneToOne
    private Accounts account;

    @OneToOne
    private Role role_who_can_access;

//    @OneToMany(mappedBy = "accounts_who_can_accept", cascade = CascadeType.ALL)
    private List<Long> roles_who_can_accept = new ArrayList<>();
}
