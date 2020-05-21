package service;

import java.util.List;

import domain.Customer;

public interface CustomerManagementServiceLocal {
	
	public void registerCustomer(Customer customer);

	public List<Customer> getAllCustomer();

	public List<Customer> searchBysurname(String surname);

	public Customer removeCustomer(Customer customer);
}
