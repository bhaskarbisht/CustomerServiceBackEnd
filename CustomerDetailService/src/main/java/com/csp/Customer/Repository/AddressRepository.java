package com.csp.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csp.Customer.Entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
