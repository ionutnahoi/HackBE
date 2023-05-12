package com.hacktm.hackbe.repo;

import com.hacktm.hackbe.entity.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepo extends JpaRepository<Access, Long> {
}
