package com;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main (String[] args) {
		
		Logger logger = Logger.getLogger("logger");
		
		SpringApplication.run(Application.class, args);
		logger.log(Level.INFO, "erreur");
	}
}
