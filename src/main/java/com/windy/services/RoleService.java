package com.windy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.windy.domains.Role;
import com.windy.repositories.RoleRepository;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRolesService() {
        return roleRepository.findAll();
    }

    public Role getRoleByNameService(String name) {
        return roleRepository.findByName(name);
    }
}
