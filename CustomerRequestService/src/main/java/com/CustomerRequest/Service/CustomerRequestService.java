package com.CustomerRequest.Service;

import java.util.List;

import com.CustomerRequest.Entity.CustomerRequest;

public interface CustomerRequestService {

	Long saveCustomerRequest(CustomerRequest customerRequest);

	List<CustomerRequest> getAllCustomerRequest(Long customerId);

}
