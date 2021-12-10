package com.gees.App.controllers;

import java.util.List;

import javax.validation.Valid;

import com.gees.App.models.RequestModel;
import com.gees.App.repositories.RequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/request")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class RequestController {
    
    private @Autowired RequestRepository repository;

    @PostMapping
    public ResponseEntity<RequestModel> save(@Valid @RequestBody RequestModel newRequest) {
        return ResponseEntity.status(201).body(repository.save(newRequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<RequestModel>> getAllRequests() {
        return ResponseEntity.status(201).body(repository.findAll());
    }
}
