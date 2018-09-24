package com.tecnofactor.examen.poliza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.tecnofactor.examen.poliza")
public class PolizaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolizaApplication.class, args);
	}
}
