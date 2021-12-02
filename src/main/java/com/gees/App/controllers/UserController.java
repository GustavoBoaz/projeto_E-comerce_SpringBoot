package com.gees.App.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.gees.App.models.UserModel;
import com.gees.App.repositories.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	private @Autowired UserRepository repository;

	@GetMapping("/all")
	public ResponseEntity<List<UserModel>> findAll() {
		List<UserModel> list = repository.findAll();

		if (list.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(list);
		}
	}

	@GetMapping("/{id_user}")
	public ResponseEntity<UserModel> findById(@PathVariable(value = "id_user") Long idUser) {
		Optional<UserModel> optional = repository.findById(idUser);
		
		if (optional.isPresent()) {
			return ResponseEntity.status(200).body(optional.get());
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não existe!");
		}
	}
	
	@GetMapping("/email/{email_user}")
	public ResponseEntity<UserModel> findByEmail(@PathVariable(value = "email_user") String emailUser){
		return repository.findByEmail(emailUser).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email não existe!"));
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<UserModel>> findAllByName(
			@RequestParam(defaultValue = "") String nameUser,
			@RequestParam(defaultValue = "") String emailUser){
		return ResponseEntity.status(200).body(repository.findAllByNameContainingAndEmailContaining(nameUser, emailUser));
	}

	@PostMapping("/save")
	public ResponseEntity<UserModel> save(@RequestBody UserModel newUser) {
		return ResponseEntity.status(201).body(repository.save(newUser));
	}

	@PutMapping("/update")
	public UserModel update(@RequestBody UserModel newUser) {
		return repository.save(newUser);
	}

	@DeleteMapping("/{id_user}")
	public void delete(@PathVariable(value = "id_user") Long idUser) {
		repository.deleteById(idUser);
	}

}
