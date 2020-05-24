package service;

import java.util.List;

import javax.ejb.Remote;

import domain.Customer;

@Remote
public interface CustomerManagementService {

	public void registerCustomer(Customer customer) throws ServiceUnavailableException;

	public List<Customer> getAllCustomers();

	public List<Customer> searchBySurname(String surname);

	public void removeCustomer(int id);

	Customer identifyCustomer(int id);
}