package com.gees.App.steps;


import com.gees.App.models.UserModel;
import com.gees.App.models.dtos.UserCredentialsDTO;
import com.gees.App.models.dtos.UserLoginDTO;
import com.gees.App.models.dtos.UserRegisterDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserGetProfileByPathSteps {

    private @Autowired TestRestTemplate restTemplate;
    private ResponseEntity<UserCredentialsDTO> responseCredentials;
    private ResponseEntity<UserModel> responseProfile;
    private HttpHeaders header;
    private UserRegisterDTO userRegisterDTO;
    private UserLoginDTO userLoginDTO;

    @Before
    public void setUp() {
        userRegisterDTO = new UserRegisterDTO("Pamela Boaz", "pamela@email.com", "134652");
        userLoginDTO = new UserLoginDTO("pamela@email.com", "134652");
        header = new HttpHeaders();
        header.add("Content-Type", "application/json");
    }

    @Given("I am registred and logged in the system")
    public void iAmRegistredAndLoggedInTheSystem() {
        restTemplate.exchange("/api/v1/user", HttpMethod.POST, new HttpEntity<UserRegisterDTO>(userRegisterDTO), UserModel.class);
        responseCredentials = restTemplate.exchange("/api/v1/user/credentials", HttpMethod.PUT, new HttpEntity<UserLoginDTO>(userLoginDTO), UserCredentialsDTO.class);
    }

    @When("I send a request to the with valid token in path")
    public void iSendARequestToTheWithValidTokenInPath() {
        header.add("Authorization", responseCredentials.getBody().getTokenBasic());
        responseProfile = restTemplate.exchange("/api/v1/user/" + responseCredentials.getBody().getToken(), HttpMethod.GET, new HttpEntity<>(header), UserModel.class);
    }

    @Then("I should get the user profile")
    public void iShouldGetTheUserProfile() {
        assert responseProfile.getBody().getName().equals("Pamela Boaz");
    }
    
}
