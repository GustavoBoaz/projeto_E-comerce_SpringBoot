package com.gees.App.controllers;

import java.util.List;

import javax.validation.Valid;

import com.gees.App.models.ProductModel;
import com.gees.App.repositories.ProductRepository;
import com.gees.App.util.DrinkTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ProductController {

    private @Autowired ProductRepository repository;

    @PostMapping
    public ResponseEntity<ProductModel> save(@Valid @RequestBody ProductModel newProduct) {
        return ResponseEntity.status(201).body(repository.save(newProduct));
    }

    @PutMapping
    public ResponseEntity<ProductModel> update(@Valid @RequestBody ProductModel newProduct) {
        return ResponseEntity.status(200).body(repository.save(newProduct));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ProductModel>> search(@RequestParam(required = true) DrinkTypes typeProduct,
            @RequestParam(defaultValue = "") String product) {
        return ResponseEntity.status(200)
                .body(repository.findAllByTypeProductAndProductContaining(typeProduct, product));
    }

    @DeleteMapping("{id_product}")
    public ResponseEntity<?> deleteById(@PathVariable(value = "id_product") Long id){
        repository.deleteById(id);
        return ResponseEntity.status(200).build();
    }
    
}
