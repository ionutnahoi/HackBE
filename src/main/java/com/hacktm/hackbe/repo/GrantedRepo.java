package com.hacktm.hackbe.repo;

import com.hacktm.hackbe.entity.Granted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantedRepo extends JpaRepository<Granted,Long> {
}
