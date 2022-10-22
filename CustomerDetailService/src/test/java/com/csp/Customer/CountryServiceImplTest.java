package com.csp.Customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.csp.Customer.Entity.Country;
import com.csp.Customer.Entity.State;
import com.csp.Customer.Repository.CountryRepository;
import com.csp.Customer.Repository.StateRepository;
import com.csp.Customer.Service.CountryService;
import com.csp.Customer.Service.CountryServiceImpl;

@SpringBootTest
public class CountryServiceImplTest {
	
	@Mock
	CountryRepository countryRepository;

	@Mock
	StateRepository stateRepository;
	
	@InjectMocks
      CountryService countryService=new CountryServiceImpl();
	
	@DisplayName("Get AllCountries-Success Scenario")
	@Test
	void test_getAllCountries() {
		List<Country> listcountries=getMockCounties();
		Mockito.when(countryRepository.findAll()).thenReturn(listcountries);

		
		List<Country> countryResponse =countryService.getAllCountries();
		Mockito.verify(countryRepository,times(1)).findAll();
		Assertions.assertNotNull(countryResponse);
		assertEquals(listcountries.size(), countryResponse.size());
	}
	
	@DisplayName("Get AllCountries-failure Scenario")
	@Test
	void test_getAllCountries_notfound() {
		List<Country> listcountries=getMockCountiesZero();
		Mockito.when(countryRepository.findAll()).thenReturn(listcountries);

		
		List<Country> countryResponse =countryService.getAllCountries();
		Mockito.verify(countryRepository,times(1)).findAll();
		Assertions.assertNotNull(countryResponse);
		assertEquals(listcountries.size(), countryResponse.size());
	}
	
	@DisplayName("Get AllStates-Success Scenario")
	@Test
	void test_getAllStates() {
		List<State> liststate=getMockStates();
		Mockito.when(stateRepository.findByCountryId(1)).thenReturn(liststate);

		
		List<State> stateResponse =countryService.getAllStates(1);
		Mockito.verify(stateRepository,times(1)).findByCountryId(1);
		Assertions.assertNotNull(stateResponse);
		assertEquals(liststate.size(), stateResponse.size());
	}



	private List<State> getMockStates() {
	State state1=new State(1,"up",1);
	State state2=new State(2,"delhi",1);

	List<State> lst=List.of(state1,state2);
	return lst;
	}

	private List<Country> getMockCounties() {
		Country country1=new Country(1L,"Ind","INDIA");
		Country country2=new Country(2L,"US","America");

	List<Country> lst=List.of(country1,country2);
		return lst;
	}
	
	private List<Country> getMockCountiesZero() {
	

	List<Country> lst=List.of();
		return lst;
	}

}
