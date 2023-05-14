package com.hacktm.hackbe.controller;

import com.hacktm.hackbe.entity.Access;
import com.hacktm.hackbe.entity.User;
import com.hacktm.hackbe.service.AccessService;
import com.hacktm.hackbe.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Access")
@CrossOrigin
public class AccessController {

    private final AccessService accessService;

    private final UserService userService;

    public AccessController(AccessService accessService, UserService userService) {
        this.accessService = accessService;
        this.userService = userService;
    }

    @PostMapping("/{account}/{role}/{role_who_accepts}")
    public void save(@PathVariable Long account, @PathVariable String role, @PathVariable String role_who_accepts) {
        accessService.save(account, role, role_who_accepts);
    }

    @GetMapping
    public List<Access> getAll() {
        return accessService.getAll();
    }

    @GetMapping("/access_role/{mail}")
    public List<Access> getAccessByRole(@PathVariable String mail) {
        User user = userService.getUserByMail(mail);
       return  accessService.getAccessByRole(user.getRole().getName());
    }
}
