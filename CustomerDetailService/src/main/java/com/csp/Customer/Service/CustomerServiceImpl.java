package com.csp.Customer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csp.Customer.Entity.Customer;
import com.csp.Customer.Repository.CustomerRepository;

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



}
