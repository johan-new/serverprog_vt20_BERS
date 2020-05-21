package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import domain.Customer;

@Stateless 
@Webservice(name="CustomerManagementWebservice")
public class CustomerManagementWebserviceImplementation {

	@Inject 
	private CustomerManagementServiceLocal service; 
	
	public Customer getCustomerBySurname(String surname) {
		return service.searchBySurname(surname); 
}

	public List<Customer>getAllCustomer() {
		return service.getAllCustomer();
	}

}