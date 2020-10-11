package com.ufpssgd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan("com.ufpssgd.modelo.entidad")
@SpringBootApplication
public class UfpsSgdApplication {

	public static void main(String[] args) {
		SpringApplication.run(UfpsSgdApplication.class, args);
	}

}
