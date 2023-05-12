package com.hacktm.hackbe.repo;

import com.hacktm.hackbe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    boolean existsByMail(String mail);
}
