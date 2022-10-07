package com.csp.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.csp.Customer.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query("SELECT u fROM Customer u where u.email=?1")
	Customer findByEmail(String email);

	boolean existsByEmail(String email);
}
