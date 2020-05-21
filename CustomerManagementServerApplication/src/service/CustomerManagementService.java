package service;

import java.util.List;

import javax.ejb.Remote;

import domain.Customer;

@Remote
public interface CustomerManagementService {

	public void registerCustomers(Customer customer);

	public List<Customer> getAllCustomers();

	public List<Customer> searchBysurname(String surname);

}
