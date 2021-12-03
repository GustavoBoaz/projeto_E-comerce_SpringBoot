package com.gees.App.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gees.App.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	/**
	 * Método utilizado para pesquisar por email na coluna email do bando de dados
	 * 
	 * @param emailUser
	 * @return Optional<UserModel>
	 * @author BORGES
	 * @since 1.0
	 * 
	 * @see findAllByNameContainingAndEmailContaining
	 */
	Optional<UserModel> findByEmail(String emailUser);
	
	/**
	 * Método utilizado para pesquisar por emal ou name no bancode dados
	 * 
	 * @param name
	 * @param email
	 * @return List<UserModel>
 	 * @author BORGES
	 * @since 1.0
	 * 
	 * @see findByEmail
	 */
	List<UserModel> findAllByNameContainingAndEmailContaining(String name, String email);

}
