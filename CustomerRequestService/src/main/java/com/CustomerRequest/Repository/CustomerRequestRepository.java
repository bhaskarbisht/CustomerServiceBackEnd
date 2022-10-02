package com.CustomerRequest.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CustomerRequest.Entity.CustomerRequest;

@Repository
public interface CustomerRequestRepository extends JpaRepository<CustomerRequest, Long>{

	@Query("SELECT u fROM CustomerRequest u where u.customerId=?1")
	List<CustomerRequest> findRequestsByCustomerId(Long cId);
	
}
