package com.gees.App.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gees.App.models.UserModel;

/**
 * Inteface reponseble for inheriting crud methods
 * 
 * @author Boaz
 * @since 1.0
 * @see ProductRepository
 * @see RequestRepository
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	/**
	 * Method used to search by token
	 * 
	 * @param token
	 * @return Optional<UserModel>
	 * @author Boaz
	 * @since 1.0
	 * 
	 */
	Optional<UserModel> findByToken(String token);

	/**
	 * Method used to search by email
	 * 
	 * @param email
	 * @return Optional<UserModel>
	 * @author Boaz
	 * @since 1.0
	 * 
	 */
	Optional<UserModel> findByEmail(String email);

}
