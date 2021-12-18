package com.gees.App.controllers;

import javax.validation.Valid;

import com.gees.App.models.UserModel;
import com.gees.App.models.dtos.UserCredentialsDTO;
import com.gees.App.models.dtos.UserLoginDTO;
import com.gees.App.models.dtos.UserRegisterDTO;
import com.gees.App.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(allowedHeaders = "*", origins = "*")
@Tag(name = "User resources", description = "Administer the user on the system")
public class UserController {

    private @Autowired UserServices services;

    @Operation(summary = "Register new user")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Created",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class)) }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "User already registered",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
        )
    })
    @PostMapping
    public ResponseEntity<UserModel> save(@Valid @RequestBody UserRegisterDTO newUser){
    	return services.registerUser(newUser);
    }
    
    @Operation(summary = "Get credentials")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Accredited user",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserCredentialsDTO.class)) }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Incorrect email or password",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
        )
    })
    @PutMapping("/credentials")
    public ResponseEntity<UserCredentialsDTO> credentials(@Valid @RequestBody UserLoginDTO user){
    	return services.getCredentials(user);
    }

    @Operation(summary = "Get user profile with Basic auth")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Profile",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class)) }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Incorrect Basic token",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
        )
    })
    @GetMapping
    public ResponseEntity<UserModel> getProfileByBasicToken(@RequestHeader("Authorization") String auth){
        return services.getProfile(auth.replace("Basic ",""));
    }

    @Operation(summary = "Get user profile with token")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Profile",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = UserModel.class)) }
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Incorrect token",
            content = @Content
        ),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content = @Content
        )
    })
    @GetMapping("/{token}")
    public ResponseEntity<UserModel> getProfileByToken(@PathVariable String token){
        return services.getProfile(token);
    }
    
}
