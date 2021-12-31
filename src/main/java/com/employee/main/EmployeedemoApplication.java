package com.employee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.employee.model")
@ComponentScan("com.employee")
@EnableJpaRepositories("com.employee.repository")
public class EmployeedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeedemoApplication.class, args);
	}

}
