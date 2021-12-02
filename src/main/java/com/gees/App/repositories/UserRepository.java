package com.gees.App.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gees.App.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	Optional<UserModel> findByEmail(String emailUser);
	
	List<UserModel> findAllByNameContainingAndEmailContaining(String name, String email);

}
