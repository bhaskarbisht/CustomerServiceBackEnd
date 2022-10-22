package com.csp.Customer.Service;

import java.util.Optional;

import com.csp.Customer.Entity.Customer;
import com.csp.Customer.Model.CustomerModel;

public interface CustomerService {

	Long saveCustomer(CustomerModel customer);

	Optional<Customer> findCustomerByEmail(String email);

	Optional<Customer> getCustomerByid(Long id);

	Customer updateCustomer(Customer customer, Long id);

	Boolean ifExistsUser(String email);


}
