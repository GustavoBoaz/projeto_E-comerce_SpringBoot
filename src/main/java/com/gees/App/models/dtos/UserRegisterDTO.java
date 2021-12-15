package com.gees.App.models.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRegisterDTO {

	private @NotBlank @Size(min = 2, max = 25) String name;
	private @NotBlank @Email String email;
	private @NotBlank @Size(min = 2, max = 25) String password;
	
	public UserRegisterDTO() {	}

	public UserRegisterDTO(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
