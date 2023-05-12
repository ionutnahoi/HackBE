package com.hacktm.hackbe.controller;

import com.hacktm.hackbe.entity.Accounts;
import com.hacktm.hackbe.service.AccountsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Accounts")
public class AccountsController {

    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @GetMapping("getAll")
    public List<Accounts> findAll() {
        return accountsService.findAll();
    }

    @PostMapping
    public void save(Accounts entity) {
        accountsService.save(entity);
    }

    @GetMapping("{id}")
    public Optional<Accounts> findById(Long id) {
        return accountsService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(Long id) {
        accountsService.deleteById(id);
    }

    public boolean existsById(Long id) {
        return accountsService.existsById(id);
    }
}
