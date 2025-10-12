package com.windy.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.windy.domains.User;
import com.windy.dto.RegisterDTO;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final UserService userService;

    public AuthService(PasswordEncoder passwordEncoder, RoleService roleService, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.userService = userService;
    }

    public void registerService(RegisterDTO registerDTO) {
        User user = registerDTOToUser(registerDTO);
        user.setRole(roleService.getRoleByNameService("USER"));
        userService.saveUserServie(user);
    }

    public User registerDTOToUser(RegisterDTO registerDTO) {
        User user = new User();
        user.setEmail(registerDTO.getEmail());
        user.setFullName(registerDTO.getFullName());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setAddress(registerDTO.getAddress());
        user.setPhone(registerDTO.getPhone());
        return user;
    }

}
