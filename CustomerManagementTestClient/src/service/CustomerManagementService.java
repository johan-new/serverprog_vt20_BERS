package service;

import java.util.List;

import javax.ejb.Remote;
import javax.naming.ServiceUnavailableException;

import domain.Customer;

public interface CustomerManagementService {

	public void registerCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public List<Customer> searchBySurname(String surname);

	public Customer removeCustomer(Customer customer);
	
}