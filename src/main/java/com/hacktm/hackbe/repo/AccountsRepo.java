package com.hacktm.hackbe.repo;

import com.hacktm.hackbe.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepo extends JpaRepository<Accounts, Long> {
}
