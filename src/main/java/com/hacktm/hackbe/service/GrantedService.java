package com.hacktm.hackbe.service;

import com.hacktm.hackbe.entity.Granted;
import com.hacktm.hackbe.repo.GrantedRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrantedService {

    private GrantedRepo grantedRepo;

    public List<Granted> findAll() {
        return grantedRepo.findAll();
    }

    public void save(Granted entity) {
        grantedRepo.save(entity);
    }

    public Optional<Granted> findById(Long aLong) {
        return grantedRepo.findById(aLong);
    }

    public void deleteById(Long aLong) {
        grantedRepo.deleteById(aLong);
    }

    public boolean existsById(Long aLong) {
        return grantedRepo.existsById(aLong);
    }
}
