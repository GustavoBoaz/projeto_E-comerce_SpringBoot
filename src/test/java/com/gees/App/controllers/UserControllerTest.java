package com.gees.App.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.gees.App.models.UserModel;
import com.gees.App.models.dtos.UserCredentialsDTO;
import com.gees.App.models.dtos.UserLoginDTO;
import com.gees.App.models.dtos.UserRegisterDTO;
import com.gees.App.services.UserServices;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

	private @Autowired TestRestTemplate testRest;
	private @Autowired UserServices services;

	@Test
	@Order(3)
	@DisplayName("Register new User!")
	void saveNewUserReturn201() {
		//Given
		HttpEntity<UserRegisterDTO> request = new HttpEntity<UserRegisterDTO>(
				new UserRegisterDTO("Luan Boaz","luan@email.com","134652"));
		
		//When
		ResponseEntity<UserModel> response =
				testRest.exchange("/api/v1/user", HttpMethod.POST, request, UserModel.class);
		
		//Then
		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	
	@Test
	@Order(2)
	@DisplayName("Get credentials User!")
	void getCredentialsUserReturn200() {
		//Given
		services.registerUser(new UserRegisterDTO("Fabricio Boaz","fabricio@email.com","134652"));
		HttpEntity<UserLoginDTO> request = new HttpEntity<UserLoginDTO>(
				new UserLoginDTO("fabricio@email.com","134652"));
		
		//When
		ResponseEntity<UserCredentialsDTO> response =
				testRest.exchange("/api/v1/user/credentials", HttpMethod.PUT, request, UserCredentialsDTO.class);
		
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	@Order(1)
	@DisplayName("Get profile User!")
	void getProfileUserReturn200() {
		//Given
		services.registerUser(new UserRegisterDTO("Jessica Boaz","jessica@email.com","134652"));
		
		//When
		ResponseEntity<UserModel> response =
				testRest.withBasicAuth("jessica@email.com", "134652")
				.exchange("/api/v1/user", HttpMethod.GET, null, UserModel.class);
		
		//Then
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

}
