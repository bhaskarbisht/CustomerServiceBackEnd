package com.csp.Customer.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csp.Customer.Entity.Customer;
import com.csp.Customer.Repository.CustomerRepository;
import com.csp.Customer.exception.ResourceNotFoundException;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Long saveCustomer(Customer customer) {

		Customer savedCustomer=customerRepository.save(customer);
		
		log.info("Customer saved with id={}",savedCustomer.getCustomerId());	
		return savedCustomer.getCustomerId();
	}

	@Override
	public Optional<Customer> findCustomerByEmail(String email) {
		Customer user=customerRepository.findByEmail(email);
		return Optional.ofNullable(user);
	}

	@Override
	public Optional<Customer> getCustomerByid(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) {
		Customer existingcustomer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
		existingcustomer.setFirstName(customer.getFirstName());
		existingcustomer.setLastName(customer.getLastName());
		existingcustomer.setPanNo(customer.getPanNo());
		existingcustomer.setDob(customer.getDob());
		existingcustomer.setContactNo(customer.getContactNo());
		existingcustomer.setAddress(customer.getAddress());
	

		customerRepository.save(existingcustomer);
		return existingcustomer;
	}



}
