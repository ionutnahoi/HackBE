package com.hacktm.hackbe.controller;

import com.hacktm.hackbe.entity.Access;
import com.hacktm.hackbe.entity.Accounts;
import com.hacktm.hackbe.service.AccessService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Access")
public class AccessController {

    private final AccessService accessService;

    public AccessController(AccessService accessService) {
        this.accessService = accessService;
    }

    @PostMapping("/{account}/{role}/{role_who_accepts}")
    public void save (@PathVariable Long account, @PathVariable String role, @PathVariable String role_who_accepts) {
        accessService.save(account, role, role_who_accepts);
    }

    @GetMapping
    public List<Access> getAll() {
        return accessService.getAll();
    }
}
