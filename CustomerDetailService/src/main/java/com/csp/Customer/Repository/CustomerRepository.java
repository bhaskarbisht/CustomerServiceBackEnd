package com.csp.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csp.Customer.Entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
