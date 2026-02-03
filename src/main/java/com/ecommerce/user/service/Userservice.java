package com.ecommerce.user.service;

import com.ecommerce.user.model.UserModel;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class Userservice {

    UserRepository userRepository;
    public Userservice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public UserModel getUserById(Integer id){
        return userRepository.findById(id).get();
    }

    public void addUser(UserModel user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, UserModel user) {
        Optional<UserModel> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
           existingUser.get().setLastName(user.getLastName());
           existingUser.get().setFirstName(user.getFirstName());
           existingUser.get().setEmail(user.getEmail());
           existingUser.get().setAge(user.getAge());
           userRepository.save(existingUser.get());
        }
    }


    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
