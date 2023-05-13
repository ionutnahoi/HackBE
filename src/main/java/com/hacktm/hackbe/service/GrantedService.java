package com.hacktm.hackbe.service;

import com.hacktm.hackbe.entity.Granted;
import com.hacktm.hackbe.repo.GrantedRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrantedService {
    @Autowired
    private GrantedRepo grantedRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountsService accountsService;

    public List<Granted> findAll() {
        return grantedRepo.findAll();
    }

    public void save(String email, String account_name) {
        Granted granted = new Granted();
        granted.setUser(userService.getUserByMail(email));
        granted.setAccount(accountsService.findByName(account_name));
        grantedRepo.save(granted);
    }

    public Optional<Granted> findById(Long aLong) {
        return grantedRepo.findById(aLong);
    }

    public void deleteById(Long aLong) {
        grantedRepo.deleteById(aLong);
    }

    public boolean existsById(Long aLong) {
        return grantedRepo.existsById(aLong);
    }
}
