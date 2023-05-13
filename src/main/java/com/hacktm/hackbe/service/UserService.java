package com.hacktm.hackbe.service;

import com.hacktm.hackbe.entity.Role;
import com.hacktm.hackbe.entity.User;
import com.hacktm.hackbe.repo.RoleRepo;
import com.hacktm.hackbe.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    public <S extends User> S save(S entity, String role) throws Exception {
        Role roleToSet = roleRepo.findByName(role);
        entity.setRole(roleToSet);

        return userRepo.save(entity);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findById(Long aLong) {
        return userRepo.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return userRepo.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        userRepo.deleteById(aLong);
    }

    public User getUserByMail(String mail){
        return userRepo.findByMail(mail);
    }

    public List<User> findAll(Sort sort) {
        return userRepo.findAll(sort);
    }

    public boolean validation(String email, String password) {
        User user = userRepo.findByMail(email);
        return user.getPassword().equals(password);
    }
}
