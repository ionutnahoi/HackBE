package com.hacktm.hackbe.service;

import com.hacktm.hackbe.entity.Role;
import com.hacktm.hackbe.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public <S extends Role> S save(S entity) {
        return roleRepo.save(entity);
    }

    public Optional<Role> findById(Long aLong) {
        return roleRepo.findById(aLong);
    }

    public void deleteById(Long aLong) {
        roleRepo.deleteById(aLong);
    }

    public boolean existsById(Long aLong) {
        return roleRepo.existsById(aLong);
    }

    public boolean existByName(String name) {
        return roleRepo.existsByName(name);
    }
}
