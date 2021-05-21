package com.example.service;


import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    public User findUser(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User delete(int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null){
            userRepository.delete(user);
            return user;
        } else {
            return null;
        }
    }
}
