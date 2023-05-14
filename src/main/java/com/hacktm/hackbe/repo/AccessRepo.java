package com.hacktm.hackbe.repo;

import com.hacktm.hackbe.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessRepo extends JpaRepository<Access, Long> {
    @Query("select b from Access b where b.role_who_can_access.name=:role_name")
    List<Access> findByRole_who_can_access(String role_name);

    @Query("select b from Access b where b.roles_who_can_accept=:role_name")
    List<Access> findByRoles_who_can_accept(Long role_name);
}
