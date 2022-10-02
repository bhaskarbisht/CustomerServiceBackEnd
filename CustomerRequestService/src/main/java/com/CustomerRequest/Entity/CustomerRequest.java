package com.CustomerRequest.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long requestId;
	
	Long customerId;
	
	String category;
	
	String requestStatus;
	
	Date requestDate;
	
	String description;
	
	
	

}
