package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * Clase Application
 *
 * Aplicacion inicial del microservicio de Alumno
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@EntityScan(basePackages="com.curso.model")
@EnableJpaRepositories(basePackages="com.curso.dao")
@SpringBootApplication(scanBasePackages={"com.curso.controller", "com.curso.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * Constructor del template
	 *
	 * @return Nueva instancia de objeto de tipo RestTemplate 
	 */
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
}
