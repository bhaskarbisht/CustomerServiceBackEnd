package com.csp.Customer.Service;

import java.util.Optional;

import com.csp.Customer.Entity.Customer;

public interface CustomerService {

	Long saveCustomer(Customer customer);

	Optional<Customer> findCustomerByEmail(String email);


}
