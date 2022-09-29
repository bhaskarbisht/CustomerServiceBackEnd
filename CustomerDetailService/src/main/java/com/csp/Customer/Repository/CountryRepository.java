package com.csp.Customer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csp.Customer.Entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{

}
