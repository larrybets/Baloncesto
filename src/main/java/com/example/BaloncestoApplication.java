package com.example;

import com.example.service.JugadorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaloncestoApplication {

	public static void main(String[] args) {

		// contexto que repsenta la alicacion
		ConfigurableApplicationContext context= SpringApplication.run(BaloncestoApplication.class, args);
		context.getBean(JugadorService.class).testJugador();
	}
}
