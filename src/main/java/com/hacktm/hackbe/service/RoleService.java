package com.hacktm.hackbe.service;

import com.hacktm.hackbe.entity.Role;
import com.hacktm.hackbe.repo.RoleRepo;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.MediaSize;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    private RoleRepo roleRepo;

    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    public void save(Role entity) {
        roleRepo.save(entity);
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
        return roleRepo.existByName(name);
    }
}
