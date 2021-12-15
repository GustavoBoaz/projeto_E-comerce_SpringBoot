package com.gees.App.models.dtos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserRegisterDTOTest {
	
	private UserRegisterDTO dtoError;
	private UserRegisterDTO dtoNotError;
	private Validator validator;
	private Set<ConstraintViolation<UserRegisterDTO>> validation;
	private @Autowired ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	@BeforeEach
	public void start() {
		validator = factory.getValidator();
	}

	@Test
	@DisplayName("Test Error name")
	void testNameBlankReturnError() {
		//given
		dtoError = new UserRegisterDTO("", "josiane@email.com", "134652");
		
		//when
		validation = validator.validate(dtoError);
		
		//then
		assertFalse(validation.isEmpty());
	}
	
	@Test
	@DisplayName("Test OK UserRegisterDTO")
	void testUserRegisterDTONotError() {
		
		//given
		dtoNotError = new UserRegisterDTO("Gustavo Boaz", "gustavo@email.com", "134652");
		
		//when
		validation = validator.validate(dtoNotError);
		
		//then
		assertTrue(validation.isEmpty());
	}

}
