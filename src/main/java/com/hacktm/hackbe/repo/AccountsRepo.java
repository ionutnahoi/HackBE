package com.hacktm.hackbe.repo;

import com.hacktm.hackbe.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepo extends JpaRepository<Accounts, Long> {
    Accounts findByName(String account_name);
}
