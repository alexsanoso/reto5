package com.reto5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.reto5.modelo"})
public class Reto5Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto5Application.class, args);
	}

}