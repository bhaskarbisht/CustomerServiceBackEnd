package com.csp.Customer.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.csp.Customer.Entity.Country;
import com.csp.Customer.Entity.State;
import com.csp.Customer.Service.CountryService;

@RestController
@CrossOrigin(origins = "*")
public class AddressController {
	
	@Autowired
	CountryService countryService;
	
@GetMapping("/countries")
public List<Country> getCountries(){
	return countryService.getAllCountries();
}

@GetMapping("/states/{id}")
public List<State> getStatesByid(@PathVariable Integer id){
	return countryService.getAllStates(id);
}


}
