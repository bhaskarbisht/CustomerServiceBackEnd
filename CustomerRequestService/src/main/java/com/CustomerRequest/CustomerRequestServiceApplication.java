package com.CustomerRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerRequestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRequestServiceApplication.class, args);
	}

}
