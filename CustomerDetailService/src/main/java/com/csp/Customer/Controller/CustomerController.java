package com.csp.Customer.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csp.Customer.Entity.Customer;
import com.csp.Customer.Model.CustomerModel;
import com.csp.Customer.Model.LoginRequest;
import com.csp.Customer.Service.CustomerService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/createCustomer")
	public ResponseEntity<Long> saveCustomer(@RequestBody CustomerModel customer){
		
		Long customerId=customerService.saveCustomer(customer);
		return new  ResponseEntity<>(customerId,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public Customer LoginUser(@RequestBody LoginRequest logindata) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Optional<Customer> user = customerService.findCustomerByEmail(logindata.getEmail());
		if (user.isPresent()) {
			Customer rs = user.get();
			if(encoder.matches(logindata.getPassword(), rs.getPassword())) {
				return rs;
			}
			
//			if (rs.getPassword().equals(logindata.getPassword())) {
//				return rs;
//			}
			
		}
		return null;
			


	}
	
	@PostMapping("/checkDuplicate")
	public ResponseEntity<?> checkDuplicateUser(@RequestBody String email){
		return ResponseEntity.ok(customerService.ifExistsUser(email));
	}	
	
	
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable Long id) {
		return customerService.getCustomerByid(id);
		
	}

	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){
	return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id),HttpStatus.OK);	
	}
	
}
