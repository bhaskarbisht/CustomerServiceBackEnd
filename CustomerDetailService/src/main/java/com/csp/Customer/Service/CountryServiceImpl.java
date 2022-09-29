package com.csp.Customer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csp.Customer.Entity.Country;
import com.csp.Customer.Entity.State;
import com.csp.Customer.Repository.CountryRepository;
import com.csp.Customer.Repository.StateRepository;

@Service
public class CountryServiceImpl implements CountryService {
@Autowired
CountryRepository countryRepository;

@Autowired
StateRepository stateRepository;
	
	@Override
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	@Override
	public List<State> getAllStates(Integer Id) {
		
		return stateRepository.findByCountryId(Id);
	}
	

}
