package com.gees.App.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gees.App.models.UserModel;
import com.gees.App.models.dtos.UserRegisterDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserGetProfileByHeaderSteps {

    private @Autowired TestRestTemplate restTemplate;
    private HttpEntity<UserRegisterDTO> requestRegister;
    private HttpHeaders header;
    private HttpEntity<?> requestProfile;
    private ResponseEntity<UserModel> responseProfile;

    @Given("a name {string} and email {string} and password {string}, which exists in the database for the access")
    public void registerUserInDatabase(String name, String email, String password) {
        requestRegister = new HttpEntity<UserRegisterDTO>(new UserRegisterDTO(name, email, password));
        restTemplate.exchange("/api/v1/user", HttpMethod.POST, requestRegister, UserModel.class);
    }

    @When("I send a {string} request to {string} with the Authorization {string} in the header")
    public void sendRequest(String method, String url, String authorization) {
        header = new HttpHeaders();
        header.add("Authorization", authorization);
        requestProfile = new HttpEntity<>(header);
        responseProfile = restTemplate.exchange(url, HttpMethod.valueOf(method), requestProfile, UserModel.class);
    }

    @Then("I get a {int} status code")
    public void validResponse(int statusCode) {
        assertEquals(statusCode, responseProfile.getStatusCodeValue());
    }
    
}
