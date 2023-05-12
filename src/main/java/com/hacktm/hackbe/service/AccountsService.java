package com.hacktm.hackbe.service;

import com.hacktm.hackbe.entity.Accounts;
import com.hacktm.hackbe.repo.AccountsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {
    private AccountsRepo accountsRepo;

    public List<Accounts> findAll() {
        return accountsRepo.findAll();
    }

    public void save(Accounts entity) {
        accountsRepo.save(entity);
    }

    public Optional<Accounts> findById(Long aLong) {
        return accountsRepo.findById(aLong);
    }

    public void deleteById(Long aLong) {
        accountsRepo.deleteById(aLong);
    }

    public boolean existsById(Long aLong) {
        return accountsRepo.existsById(aLong);
    }
}