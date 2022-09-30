package com.CustomerRequest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerRequest.Entity.CustomerRequest;
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

}
