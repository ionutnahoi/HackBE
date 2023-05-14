package com.hacktm.hackbe.controller;

import com.hacktm.hackbe.entity.Access;
import com.hacktm.hackbe.entity.Granted;
import com.hacktm.hackbe.entity.User;
import com.hacktm.hackbe.service.AccessService;
import com.hacktm.hackbe.service.GrantedService;
import com.hacktm.hackbe.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("Granted")
@CrossOrigin
public class GrantedController {
    private final GrantedService grantedService;

    private final UserService userService;

    private final AccessService accessService;

    public GrantedController(GrantedService grantedService, UserService userService, AccessService accessService) {
        this.grantedService = grantedService;
        this.userService = userService;
        this.accessService = accessService;
    }

    @GetMapping("getAll")
    public List<Granted> findAll() {
        return grantedService.findAll();
    }

    @PostMapping("{email}/{account_name}")
    public void save(@PathVariable String email, @PathVariable String account_name) {
        grantedService.save(email, account_name);
    }

    @GetMapping("{id}")
    public Optional<Granted> findById(@PathVariable Long id) {
        return grantedService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        grantedService.deleteById(id);
    }

    @GetMapping("toAccept/{mail}")
    public List<Granted> getWhatToAccept(@PathVariable String mail) {
        User user = userService.getUserByMail(mail);
        List<Granted> granteds = grantedService.findAll();
        List<Access> acces_user_can_accept = new ArrayList<>();
        acces_user_can_accept = accessService.getByRolesICanAccept(user.getRole().getId());
        List<Granted> new_List = new ArrayList<>();

        for (Granted granted : granteds) {
            for (Access access : acces_user_can_accept) {
                if (Objects.equals(access.getAccount().getId(), granted.getAccount().getId())) {
                    new_List.add(granted);
                }
            }
        }
        return new_List;

    }

    public boolean existsById(@PathVariable Long aLong) {
        return grantedService.existsById(aLong);
    }
}
