package com.csp.Customer;

import java.sql.Date;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.csp.Customer.Entity.Address;
import com.csp.Customer.Entity.Customer;
import com.csp.Customer.Repository.CustomerRepository;
import com.csp.Customer.Service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerServiceTest {
	
	private MockMvc mockMvc;
	
	ObjectMapper objectMapper=new ObjectMapper();
	ObjectWriter objectWritter= objectMapper.writer();
	
	@Mock
private CustomerRepository customerRepository;
	
	@InjectMocks
	private CustomerService customerService;
	
	Address address_1=new Address((long) 1,"Dlhu32","India","delhi","110086");
	Customer customer_1=new Customer((long) 1,"bhaskar","bisht","bhakarbisht@gmail.com","snjdhsd",new Date(1998-12-05),"893478374","abcd",address_1);

	Address address_2=new Address((long) 2,"7854G","India","mumbai","110034");
	Customer customer_2=new Customer((long) 2,"amit","bisht","amitbisht@gmail.com","GTHy23",new Date(1998-12-05),"784727","mnop",address_2);

	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(customerService).build();
	}
	
	@Test
	public void getCustomerByIdTest() {
		
		Mockito.when(customerRepository.findById(1L)).thenReturn(Optional.of(customer_1));
		
	}

}
