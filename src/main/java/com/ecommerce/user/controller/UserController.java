package com.ecommerce.user.controller;

import com.ecommerce.user.model.UserModel;
import com.ecommerce.user.service.Userservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    Userservice service;

    public UserController(Userservice service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<UserModel> getUser(){
        return service.getUsers();
    }

    @PostMapping("add/")
    public void addUser(@RequestBody UserModel user){
        service.addUser(user);
    }
}
