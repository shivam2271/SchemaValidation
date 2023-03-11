package com.shivam.schemaValidation.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.shivam.schemaValidation")

public class SchemaValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemaValidationApplication.class, args);
	}

}
