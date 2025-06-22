package com.example.catalogue.service;

import org.springframework.stereotype.Service;

import com.example.catalogue.entity.User;
import com.example.catalogue.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
