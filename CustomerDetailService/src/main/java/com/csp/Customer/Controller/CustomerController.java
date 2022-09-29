package com.csp.Customer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csp.Customer.Entity.Customer;
import com.csp.Customer.Service.CustomerService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Long> saveCustomer(@RequestBody Customer customer){
		
		Long customerId=customerService.saveCustomer(customer);
		return new  ResponseEntity<>(customerId,HttpStatus.CREATED);
		
	}
	
	
	
	
}
