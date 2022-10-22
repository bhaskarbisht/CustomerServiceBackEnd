package com.csp.Customer.Model;

import java.sql.Date;

import com.csp.Customer.Entity.Address;

import lombok.Data;

@Data
public class CustomerModel {

	private Long customerId;

	private String firstName;

	private String lastName;

	private String email;

	private String panNo;

	private Date dob; 

	private String contactNo;

	private String password;
	
	private Address address;

}
