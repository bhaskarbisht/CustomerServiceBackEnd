package com.csp.Customer.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_countries")
public class Country {
	
	@Column(name = "id")
	@Id
	Long id;
	
	String sortname;
	
	@Column(name = "name")
	String name;

}
