package com.gees.App.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.gees.App.models.UserModel;
import com.gees.App.models.dtos.UserCredentialsDTO;
import com.gees.App.models.dtos.UserLoginDTO;
import com.gees.App.models.dtos.UserRegisterDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserGetCredentialsSteps {

    private HttpEntity<UserRegisterDTO> requestRegister;
    private HttpEntity<UserLoginDTO> requestLogin;
    private ResponseEntity<UserCredentialsDTO> response;
    private @Autowired TestRestTemplate restTemplate;

    @Given("a name {string} and email {string} and password {string}, which exists in the database")
    public void registerUserInDatabase(String name, String email, String password) {
        requestRegister = new HttpEntity<UserRegisterDTO>(new UserRegisterDTO(name, email, password));
        restTemplate.exchange("/api/v1/user", HttpMethod.POST, requestRegister, UserModel.class);
    }

    @When("a request with {string} and {string}")
    public void prepareRequest(String email, String password) {
        requestLogin = new HttpEntity<UserLoginDTO>(new UserLoginDTO(email, password));
    }

    @And("I send a {string} request to {string}")
    public void sendRequest(String method, String url) {
        response = restTemplate.exchange(url, HttpMethod.valueOf(method), requestLogin, UserCredentialsDTO.class);
    }

    @Then("I should receive a response with status code {int}")
    public void validResponse(int statusCode) {
        assertEquals(statusCode, response.getStatusCodeValue());
    }
    
}
