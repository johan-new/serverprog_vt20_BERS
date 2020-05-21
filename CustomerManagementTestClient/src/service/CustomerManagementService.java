package service;

import java.util.List;

import domain.Customer;

public interface CustomerManagementService {

	public void registerCustomer(Customer customer);

	public List<Customer> getAllCustomers();

	public List<Customer> searchBySurname(String surname);

	public Customer removeCustomer(int id);
}