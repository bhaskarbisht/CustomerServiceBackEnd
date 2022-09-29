package com.csp.Customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerDetailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDetailServiceApplication.class, args);
	}

}
