package com.csp.Customer.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;

	private String firstName;

	private String lastName;

	private String email;

	private String panNo;

	private Date dob; 

	private String contactNo;

	private String password;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_add_id")
	private Address address;

	






}
