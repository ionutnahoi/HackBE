package com.hacktm.hackbe.controller;

import com.hacktm.hackbe.entity.Role;
import com.hacktm.hackbe.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @PostMapping
    public <S extends Role> S save(@RequestBody S entity) {
        return roleService.save(entity);
    }

    @GetMapping("{id}")
    public Optional<Role> findById(@PathVariable Long id) {
        return roleService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
    }

    public boolean existsById(@PathVariable Long id) {
        return roleService.existsById(id);
    }
}
