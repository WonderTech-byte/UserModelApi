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

    @GetMapping("id/{id}")
    public UserModel getUserByid(@PathVariable Integer id){
        return service.getUserById(id);
    }


    @PutMapping("update/id/{id}")
    public void updateUser(@RequestBody UserModel user, @PathVariable Integer id){
        service.updateUser(id, user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable Integer id){
        service.deleteUser(id);
    }
}
