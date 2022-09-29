package com.csp.Customer.Service;

import java.util.List;
import java.util.Optional;

import com.csp.Customer.Entity.Country;
import com.csp.Customer.Entity.State;

public interface CountryService {

	List<Country> getAllCountries();

	List<State> getAllStates(Integer id);

}
