package com.foxobyte.pokenary;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foxobyte.pokenary.dao.Move;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PokenaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokenaryApplication.class, args);
	}

}
