package com.boot.springWebApp.services;

import com.boot.springWebApp.models.RegisterModel;
import com.boot.springWebApp.repository.RegisterRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RegisterService {
    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }



    public RegisterModel createUser(RegisterModel registerModel) {
        return registerRepository.save(registerModel);
    }

    public List<RegisterModel> getUsers() {
        return registerRepository.findAll();
    }

    public RegisterModel getUser(Long userId) {
        return registerRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

    }

    public void removeUser(Long userId) {
        registerRepository.deleteById(userId);
    }

}
