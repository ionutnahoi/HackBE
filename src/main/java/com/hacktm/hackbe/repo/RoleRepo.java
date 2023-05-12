package com.hacktm.hackbe.repo;

import com.hacktm.hackbe.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {


    boolean existsByName(String name);
}