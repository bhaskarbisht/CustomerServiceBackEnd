package com.csp.Customer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.csp.Customer.Entity.Address;
import com.csp.Customer.Entity.Customer;
import com.csp.Customer.Repository.CustomerRepository;
import com.csp.Customer.Service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerDetailServiceApplicationTests {

	@Autowired
private CustomerService customerService;

	
	
@MockBean
private CustomerRepository customerRepository;

Address address=new Address((long) 1,"sdsd","wewe","wewe","wewe");
Customer customer=new Customer((long) 1,"bhaskar","bisht","bhakarbisht@gmail.com","snjdhsd",new Date(1998-12-05),"893478374","hjdsdh",address);

Optional<Customer> op=Optional.of(customer);

@Test
public void getCustomerByIdTest() {
	
	
	when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
	assertEquals(op, customerService.getCustomerByid(1L));
}

@Test
public void findCustomerByEmailTest() {
	when(customerRepository.findByEmail("bhaskarbisht@gmail.com")).thenReturn(customer);
	assertEquals(op, customerService.findCustomerByEmail("bhaskarbisht@gmail.com"));
	
}

@Test
public void saveCustomerTest() {
	when(customerRepository.save(customer)).thenReturn(customer);
	assertEquals(customer.getCustomerId(), customerService.saveCustomer(customer));
	
}
	
@Test
public void updateCustomerTest() {
	when(customerRepository.save(customer)).thenReturn(customer);
	assertEquals(customer, customerService.updateCustomer(customer,1L));
}

}
