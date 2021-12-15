package com.gees.App.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.gees.App.models.UserModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
class UserRepositoryTest {
	
	private @Autowired UserRepository repository;
	
	@BeforeAll
	void start() {
		
		//Given
		repository.save(new UserModel("Alan Boaz", "alan@email.com", "134652"));
		repository.save(new UserModel("Matheus Boaz", "matheus@email.com", "134652"));
		repository.save(new UserModel("Mariana Boaz", "mariana@email.com", "134652"));
		repository.save(new UserModel("Raphaella Boaz", "raphaella@email.com", "134652"));
		repository.save(new UserModel("Hercules Boaz", "hercules@email.com", "134652"));
		
	}
	
	@Test
	@DisplayName("Search valid email!")
	void searchEmailValidReturnObjectValid() {
		
		//When
		UserModel user = repository.findByEmail("raphaella@email.com").get();
		
		//Then
		assertTrue(user.getName().equals("Raphaella Boaz"));
	}
	
	@Test
	@DisplayName("Search invalid email!")
	void searchEmailInvalidReturnOptionalEmpty() {
		
		//When
		Optional<UserModel> optional = repository.findByEmail("");
		
		//Then
		assertTrue(optional.isEmpty());
	}
	
	@Test
	@DisplayName("Search name Boaz!")
	void searchFromBoazReturnFiveUsers() {
		
		//When
		List<UserModel> list = repository.findAllByNameContainingIgnoreCase("Boaz");
		
		//Then
		assertEquals(5, list.size());
	}
	
	@Test
	@DisplayName("Search name Hercules!")
	void searchFromHerculesReturnOneUser() {
		
		//When
		List<UserModel> list = repository.findAllByNameContainingIgnoreCase("Hercules");
		
		//Then
		assertEquals(1, list.size());
	}


}
