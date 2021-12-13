package com.gees.App.controllers;

import javax.validation.Valid;

import com.gees.App.models.UserModel;
import com.gees.App.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class UserController {

    private @Autowired UserRepository repository;

    @PostMapping
    public ResponseEntity<UserModel> save(@Valid @RequestBody UserModel newUser){
        return ResponseEntity.status(201).body(repository.save(newUser));
    }

    @GetMapping("/{id_user}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id_user") Long id){
        return ResponseEntity.status(200).body(repository.findById(id));
    }
    
}