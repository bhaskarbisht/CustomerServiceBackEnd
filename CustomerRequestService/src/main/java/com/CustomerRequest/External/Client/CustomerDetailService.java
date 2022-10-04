package com.CustomerRequest.External.Client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.CustomerRequest.Entity.Customer;
import com.CustomerRequest.Entity.CustomerRequest;


@FeignClient(name="CustomerDetailService/")
public interface CustomerDetailService {
	
	@GetMapping("/customer/{id}")
	 Optional<Customer> getCustomer(@PathVariable Long id);
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer);


}
