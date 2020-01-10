package com.cgt.technologies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TechnologiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnologiesApplication.class, args);
	}

}
