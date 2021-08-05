package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class UserInformationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserInformationApplication.class, args);
		
		
	}
	
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.cg")).paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("User Information Application").version("1.0")
				.description("API for User Information application built with Spring Boot").build();
	}

}
