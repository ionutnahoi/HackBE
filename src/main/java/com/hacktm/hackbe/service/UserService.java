package com.hacktm.hackbe.service;

import com.hacktm.hackbe.entity.User;
import com.hacktm.hackbe.repo.UserRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    public <S extends User> S save(S entity) throws Exception {
        boolean existsEmailOrUsername = userRepo.existsByMail(entity.getMail());
        if (existsEmailOrUsername) {
            throw new Exception("Email " + entity.getMail() + " or username " + " are invalid! ");
        }
//        boolean emailValid = EmailValidator.getInstance().isValid(entity.getMail());
        if (entity.getMail().isEmpty()) {
            return userRepo.save(entity);
        } else {
            throw new Exception("Email " + entity.getMail() + " is not valid");
        }
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

    public List<User> findAll(Sort sort) {
        return userRepo.findAll(sort);
    }
}
