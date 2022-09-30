package com.CustomerRequest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CustomerRequest.Entity.CustomerRequest;

@Repository
public interface CustomerRequestRepository extends JpaRepository<CustomerRequest, Long>{

}
