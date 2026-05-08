package com.imprenta.imprenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;

@Data

@SpringBootApplication
public class ImprentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImprentaApplication.class, args);
	}

}
