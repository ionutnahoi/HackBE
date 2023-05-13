package com.hacktm.hackbe.service;

import com.hacktm.hackbe.entity.Access;
import com.hacktm.hackbe.entity.Accounts;
import com.hacktm.hackbe.entity.Role;
import com.hacktm.hackbe.repo.AccessRepo;
import com.hacktm.hackbe.repo.AccountsRepo;
import com.hacktm.hackbe.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccessService {

    @Autowired
    private AccessRepo accessRepo;
    @Autowired
    private AccountsRepo accountsRepo;

    @Autowired
    private RoleRepo roleRepo;

    public void save(Long account, String role, Long role_who_accepts_id) {
        Accounts accountToFind = accountsRepo.findById(account).orElseThrow();
        Role findRole = roleRepo.findByName(role);
        Optional<Role> whoAccepts = roleRepo.findById(role_who_accepts_id);
        if(whoAccepts.isPresent()) {
            Long id = whoAccepts.get().getId();
            Access access = new Access();
            access.setAccount(accountToFind);
            access.setRole_who_can_access(findRole);
            access.getRoles_who_can_accept().add(id);
            accessRepo.save(access);

        }

    }

    public List<Access> getAll() {
        return accessRepo.findAll();
    }
}
