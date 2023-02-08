package com.cg.dryclean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DrycleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrycleanApplication.class, args);
		System.out.println("Started");
	}

}
