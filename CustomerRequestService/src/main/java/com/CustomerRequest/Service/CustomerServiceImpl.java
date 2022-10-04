package com.CustomerRequest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerRequest.Entity.Customer;
import com.CustomerRequest.Entity.CustomerRequest;
import com.CustomerRequest.Exception.ResourceNotFoundException;
import com.CustomerRequest.Repository.CustomerRequestRepository;

@Service
public class CustomerServiceImpl implements CustomerRequestService{
	
	@Autowired
	CustomerRequestRepository customerRequestRepository;
	


	@Override
	public Long saveCustomerRequest(CustomerRequest customerRequest) {

		CustomerRequest request= customerRequestRepository.save(customerRequest);
		return request.getRequestId();
	}

	@Override
	public List<CustomerRequest> getAllCustomerRequest(Long customerId) {
		
		return customerRequestRepository.findRequestsByCustomerId(customerId);
	}

	@Override
	public void deleteRequest(Long id) {

		customerRequestRepository.deleteById(id);
	}

	@Override
	public CustomerRequest updateCustomerRequest(Long id, CustomerRequest customerRequest) {

		CustomerRequest existingCustomerRequest = customerRequestRepository.findById(id)			
				.orElseThrow(() -> new ResourceNotFoundException("Customer request ", "id", id));
		existingCustomerRequest.setCategory(customerRequest.getCategory());
		existingCustomerRequest.setRequestDate(customerRequest.getRequestDate());
		existingCustomerRequest.setRequestStatus(customerRequest.getRequestStatus());
		existingCustomerRequest.setDescription(customerRequest.getDescription());
	
	

		customerRequestRepository.save(existingCustomerRequest);
		return existingCustomerRequest;
	
	}

}
