package com.boot.springWebApp.controllers;

import com.boot.springWebApp.models.RegisterModel;
import com.boot.springWebApp.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterController {
    private final RegisterService registerService;


    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @PostMapping("/register")
    public RegisterModel register(@RequestBody RegisterModel registerModel) {
        return registerService.createUser(registerModel);
    }

    @GetMapping("/users")
    public List<RegisterModel> fetchUsers(){
        return registerService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public RegisterModel getUser(@PathVariable Long userId){

        return registerService.getUser(userId);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        registerService.removeUser(userId);
    }
}
