package com.CustomerRequest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRequest.Entity.CustomerRequest;
import com.CustomerRequest.Service.CustomerRequestService;

@RestController
@CrossOrigin(origins ="*")
public class CustomerRequestController {
	
	@Autowired
    CustomerRequestService customerRequestService;
	
	
	@PostMapping("/createCustomerRequest")
	public ResponseEntity<Long> saveCustomer(@RequestBody CustomerRequest customerRequest){
		
		Long requestId=customerRequestService.saveCustomerRequest(customerRequest);
		return new  ResponseEntity<>(requestId,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getCustomerRequest/{customerId}")
	public List<CustomerRequest> getCustomerRequests(@PathVariable Long customerId){
		
		
		return customerRequestService.getAllCustomerRequest(customerId);
	}
	
	
}
