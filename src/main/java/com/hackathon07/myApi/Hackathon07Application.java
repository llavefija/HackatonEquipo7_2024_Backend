package com.hackathon07.myApi; // Define el paquete donde se encuentra la aplicación

import org.springframework.boot.SpringApplication; // Importa la clase SpringApplication para iniciar la aplicación
import org.springframework.boot.autoconfigure.SpringBootApplication; // Importa la anotación para habilitar la configuración automática de Spring Boot

// Anotación que indica que esta clase es la aplicación principal de Spring Boot
@SpringBootApplication
public class Hackathon07Application {

	// Método principal que se ejecuta al iniciar la aplicación
	public static void main(String[] args) {
		// Llama a SpringApplication.run para iniciar la aplicación, pasando la clase principal y los argumentos
		SpringApplication.run(Hackathon07Application.class, args);
	}

}
