package com.sapient.ota;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Tours and Travels", version = "1.0", description = "Tours & Travels Confirmation APIs"))
public class OtaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtaApplication.class, args);
	}

}
