package com.CustomerRequest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.CustomerRequest.Entity.Customer;
import com.CustomerRequest.Entity.CustomerRequest;
import com.CustomerRequest.External.Client.CustomerDetailService;
import com.CustomerRequest.Service.CustomerRequestService;

@RestController
@CrossOrigin(origins ="*")
public class CustomerRequestController {
	
	@Autowired
    CustomerRequestService customerRequestService;
	
	@Autowired
	CustomerDetailService customerDetailService;
	
	
	@PostMapping("/createCustomerRequest")
	public ResponseEntity<Long> saveCustomerRequest(@RequestBody CustomerRequest customerRequest){
		
		Long requestId=customerRequestService.saveCustomerRequest(customerRequest);
		return new  ResponseEntity<>(requestId,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/getCustomerRequest/{customerId}")
	public List<CustomerRequest> getCustomerRequests(@PathVariable Long customerId){
		
		
		return customerRequestService.getAllCustomerRequest(customerId);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<CustomerRequest> deleteRequest(@PathVariable Long id) {
		ResponseEntity<CustomerRequest> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			customerRequestService.deleteRequest(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@PutMapping("/updateRequest/{id}")
	public CustomerRequest updateRequest(@PathVariable("id") Long id,@RequestBody CustomerRequest customerRequest){
		return customerRequestService.updateCustomerRequest(id, customerRequest);
	}
	
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable Long id) {
		return customerDetailService.getCustomer(id);
		
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){
		return customerDetailService.updateCustomer(id, customer);
	}
	
	
}
