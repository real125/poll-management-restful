package com.yuri.schmidt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PollManagmentRestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollManagmentRestfulApplication.class, args);
	}

}
