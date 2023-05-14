package com.hacktm.hackbe.controller;

import com.hacktm.hackbe.entity.Role;
import com.hacktm.hackbe.entity.User;
import com.hacktm.hackbe.service.RoleService;
import com.hacktm.hackbe.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("User")
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("{nume_rol}")
    public <S extends User> S save(@PathVariable String nume_rol, @RequestBody S entity) throws Exception {
        return userService.save(entity, nume_rol);
    }

    @GetMapping("getAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public Optional<User> findById(@PathVariable Long aLong) {
        return userService.findById(aLong);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    public boolean existsById(Long aLong) {
        return userService.existsById(aLong);
    }

    @GetMapping("email/{email}")
    public Role getUserRoleByEmail(@PathVariable String email) {
        return userService.getUserByMail(email).getRole();
    }

    @GetMapping("/validation/{email}/{password}")
    public ResponseEntity<HttpStatus> checkIfEmailAndPasswordIsValid(@PathVariable String email, @PathVariable String password) {
        boolean validation = userService.validation(email, password);

        if (validation) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
