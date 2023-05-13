package com.hacktm.hackbe.controller;

import com.hacktm.hackbe.entity.Granted;
import com.hacktm.hackbe.service.GrantedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Granted")
@CrossOrigin
public class GrantedController {
    private final GrantedService grantedService;

    public GrantedController(GrantedService grantedService) {
        this.grantedService = grantedService;
    }

    @GetMapping("getAll")
    public List<Granted> findAll() {
        return grantedService.findAll();
    }

    @PostMapping
    public void save(Granted entity) {
        grantedService.save(entity);
    }

    @GetMapping("{id}")
    public Optional<Granted> findById(@PathVariable Long id) {
        return grantedService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        grantedService.deleteById(id);
    }

    public boolean existsById(@PathVariable Long aLong) {
        return grantedService.existsById(aLong);
    }
}
