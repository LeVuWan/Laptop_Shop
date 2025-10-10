package com.windy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.windy.domains.User;
import com.windy.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUserServie(User user) {
        return userRepository.save(user);
    }

    public List<User> gettAllUserService() {
        return userRepository.findAll();
    }

    public User getUserByIdService(Long id) {
        return userRepository.getById(id);
    }

    public void deleteUserService(Long id) {
        userRepository.deleteById(id);
    }
}
