package com.CustomerRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.CustomerRequest.Entity.CustomerRequest;
import com.CustomerRequest.Repository.CustomerRequestRepository;
import com.CustomerRequest.Service.CustomerRequestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRequestTest {

	@Autowired
	CustomerRequestService customerrequestService;
	
	@MockBean
	CustomerRequestRepository customerrequestrepo;
	
	CustomerRequest request_1=new CustomerRequest((long)1,(long)1,"HR","Pending",new Date(1998-12-05),"pending Request description");
	CustomerRequest request_2=new CustomerRequest((long)2,(long)1,"software","Closed",new Date(1998-12-05),"Closed Request description");


//@Test
//public void getAllCustomerRequests() {
//	
//	when(customerrequestrepo.findAll()).thenReturn(Stream.of(request_1,request_2).collect(Collectors.toList()));
//	assertEquals(2, customerrequestService.getAllCustomerRequest(1L).size());
//}

	
}
