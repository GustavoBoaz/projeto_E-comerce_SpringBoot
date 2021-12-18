package com.gees.App.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
	public OpenAPI springOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Project Gees")
						.description("This is a Ecomerce project")
						.version("v0.0.1")
						.license(new License()
								.name("Gees Brazil")
								.url("https://brazil.generation.org/"))
						.contact(new Contact()
								.name("Github Boaz")
								.url("https://github.com/GustavoBoaz/")
								.email("gustavo.boaz@hotmail.com")))
				.externalDocs(new ExternalDocumentation()
						.description("Github Project")
						.url("https://github.com/GustavoBoaz/project_Gees"));
	}

}
