package com.gees.App.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.gees.App.models.UserModel;
import com.gees.App.models.dtos.UserRegisterDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistrationSteps {
    
    private HttpEntity<UserRegisterDTO> request;
    private @Autowired TestRestTemplate restTemplate;
    private ResponseEntity<UserModel> response;

    @Given("a request with name {string} the email {string} the password {string}")
    public void createRequest(String name, String email, String password) {
        request = new HttpEntity<UserRegisterDTO>(new UserRegisterDTO(name, email, password));
    }

    @When("send a method {string} to endpoint {string}")
    public void sendRequest(String method, String url) {
        response = restTemplate.exchange(url, HttpMethod.valueOf(method), request, UserModel.class);
    }

    @Then("the response status code is {int}")
    public void validResponse(int statusCode) {
        assertEquals(statusCode, response.getStatusCodeValue());
    }
    
}
