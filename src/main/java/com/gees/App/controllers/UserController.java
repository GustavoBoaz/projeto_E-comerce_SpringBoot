package com.gees.App.controllers;

import java.util.Optional;

import javax.validation.Valid;

import com.gees.App.models.UserModel;
import com.gees.App.models.dtos.UserRegisterDTO;
import com.gees.App.repositories.UserRepository;
import com.gees.App.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    private @Autowired UserRepository repository;
    private @Autowired UserServices services;

    @PostMapping
    public ResponseEntity<UserModel> save(@Valid @RequestBody UserRegisterDTO newUser){
    	return services.registerUser(newUser);
    }

    @GetMapping("/{id_user}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id_user") Long id){
        return ResponseEntity.status(200).body(repository.findById(id));
    }
    
}
