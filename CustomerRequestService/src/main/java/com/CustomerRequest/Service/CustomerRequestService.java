package com.CustomerRequest.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.CustomerRequest.Entity.Customer;
import com.CustomerRequest.Entity.CustomerRequest;

public interface CustomerRequestService {

	Long saveCustomerRequest(CustomerRequest customerRequest);

	List<CustomerRequest> getAllCustomerRequest(Long customerId);

	void deleteRequest(Long id);

	CustomerRequest updateCustomerRequest(Long id, CustomerRequest customerRequest);

}
