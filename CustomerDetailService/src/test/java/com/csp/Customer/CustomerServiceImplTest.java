package com.csp.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.ArgumentMatchers.anyLong;
import java.sql.Date;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.csp.Customer.Entity.Address;
import com.csp.Customer.Entity.Customer;
import com.csp.Customer.Repository.CustomerRepository;
import com.csp.Customer.Service.CustomerService;
import com.csp.Customer.Service.CustomerServiceImpl;

@SpringBootTest
public class CustomerServiceImplTest {

	@Mock
	CustomerRepository customerRepository;
	
	@InjectMocks
	CustomerService customerService=new CustomerServiceImpl();
	
	@DisplayName("Get Customer By id-Success Scenario")
	@Test
	void test_getCustomerById() {
		Customer customer=getMockCustomer();
		Mockito.when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
		Optional<Customer> customerResponse =customerService.getCustomerByid(1L);
		Mockito.verify(customerRepository,times(1)).findById(anyLong());
		Assertions.assertNotNull(customerResponse);
		assertEquals(1L, customerResponse.get().getCustomerId());
	}
	
	
	@DisplayName("Get Customer ById -Failure Scenerio")
	@Test
	void test_when_Customer_not_found() {
		Mockito.when(customerRepository.findById(anyLong())).thenReturn(null);
		Optional<Customer> customerResponse =customerService.getCustomerByid(2L);
		Mockito.verify(customerRepository,times(1)).findById(anyLong());
		assertEquals(null, customerResponse);
	}
	
	@DisplayName("Get Customer By Email -Success Scenerio")
	@Test
	void test_findCustomerByEmail() {
		Customer customer=getMockCustomer();
		Mockito.when(customerRepository.findByEmail("bhaskar@gmail.com")).thenReturn(customer);
		Optional<Customer> customerResponse =customerService.findCustomerByEmail("bhaskar@gmail.com");
		Mockito.verify(customerRepository,times(1)).findByEmail("bhaskar@gmail.com");
		Assertions.assertNotNull(customerResponse);
		assertEquals("bhaskar@gmail.com", customerResponse.get().getEmail());
		
	}

	@DisplayName("Get Customer By Email -failure Scenerio")
	@Test
	void test_findCustomerByEmail_notfound() {
		Mockito.when(customerRepository.findByEmail("rahul@gmail.com")).thenReturn(null);
		Optional<Customer> customerResponse =customerService.findCustomerByEmail("rahul@gmail.com");
		Mockito.verify(customerRepository,times(1)).findByEmail("rahul@gmail.com");
		assertEquals(Optional.empty(),customerResponse );
		
	}
	
	@DisplayName("Create Customer-Success scenerio")
	@Test
	void testwhenaddCustomersuccess() {
		Customer customer=getMockCustomer();
		Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);
		Long id=customerService.saveCustomer(customer);
		
		Mockito.verify(customerRepository,times(1)).save(customer);
		assertEquals(1L, id);


	}
	
	@DisplayName("If Customer Exist scenerio")
	@Test
	void test_ifExistsUser() {
		Customer customer=getMockCustomer();
		Mockito.when(customerRepository.findByEmail("bhaskar@gmail.com")).thenReturn(customer);
		Boolean customerResponse =customerService.ifExistsUser("bhaskar@gmail.com");
		Mockito.verify(customerRepository,times(1)).findByEmail("bhaskar@gmail.com");
		assertEquals(true, customerResponse);
		
	}
	
	@DisplayName("If Customer Not Exist scenerio")
	@Test
	void test_ifNotExistsUser() {
		Customer customer=getMockCustomer();
		Mockito.when(customerRepository.findByEmail("bhaskarbisht2@gmail.com")).thenReturn(null);
		Boolean customerResponse =customerService.ifExistsUser("bhaskarbisht2@gmail.com");
		Mockito.verify(customerRepository,times(1)).findByEmail("bhaskarbisht2@gmail.com");
		assertEquals(false, customerResponse);
		
	}
	
	@DisplayName("updtae Customer Success scenerio")
	@Test
	void test_updatedCutsomer() {
		Customer customer=getMockCustomer();
		
		Mockito.when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));
		Mockito.when(customerRepository.save(any(Customer.class))).thenReturn(customer);

		Customer customerResponse =customerService.updateCustomer(customer, 1L);
		assertEquals(customer.getCustomerId(), customerResponse.getCustomerId());
		
	}
	
	private Customer getMockCustomer() {
		return Customer.builder().customerId(1L)
				.firstName("Bhaskar")
				.lastName("Bisht")
				.dob(new Date(2022-12-12))
				.contactNo("992825627")
				.email("bhaskar@gmail.com")
				.panNo("DSko878")
				.password("273626732")
				.address(Address.builder().adddressId(1L).houseNo("DL76767").state("delhi").country("India").pincode("117827").build())
				.build();
	}
	
	
	
}
