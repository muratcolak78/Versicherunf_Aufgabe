package com.Versicherung.Aufgabe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.Versicherung")
@SpringBootApplication
public class AufgabeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AufgabeApplication.class, args);
	}

}
