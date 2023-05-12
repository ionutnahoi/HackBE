package com.hacktm.hackbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;


    @JoinColumn(name = "rl_fk")
    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts account_who_wants_to_access;

    @JoinColumn(name = "rl_acc_fk")
    @ManyToOne(fetch = FetchType.LAZY)
    private Accounts accounts_who_can_accept;
}
