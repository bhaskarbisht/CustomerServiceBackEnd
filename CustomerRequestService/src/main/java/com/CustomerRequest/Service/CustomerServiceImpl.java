package com.CustomerRequest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerRequest.Entity.CustomerRequest;
import com.CustomerRequest.External.Client.CustomerDetailService;
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

}
