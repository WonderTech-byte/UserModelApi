package com.ecommerce.user.service;

import com.ecommerce.user.model.UserModel;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {

    UserRepository userRepository;
    public Userservice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(UserModel user) {
        userRepository.save(user);
    }
}
