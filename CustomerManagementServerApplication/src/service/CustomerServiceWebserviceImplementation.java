package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import domain.Customer;

@Stateless
@WebService(name="CustomerManagementWebService")
public class CustomerServiceWebserviceImplementation {
	
	@Inject 
	private CustomerManagementServiceLocal service;
	
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}
	
	
}
