package com.hacktm.hackbe.controller;

import com.hacktm.hackbe.entity.User;
import com.hacktm.hackbe.service.RoleService;
import com.hacktm.hackbe.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("User")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public <S extends User> S save(S entity) throws Exception {
        return userService.save(entity);
    }

    @GetMapping("getAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public Optional<User> findById(Long aLong) {
        return userService.findById(aLong);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(Long id) {
        userService.deleteById(id);
    }

    public boolean existsById(Long aLong) {
        return userService.existsById(aLong);
    }
}
