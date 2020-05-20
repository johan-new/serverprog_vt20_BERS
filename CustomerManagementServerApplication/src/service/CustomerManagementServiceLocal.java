package service;

import java.util.List;
import javax.ejb.Local;

import domain.Customer;

@Local
public interface CustomerManagementServiceLocal {
	
	public void registerCustomer(Customer customer) throws ServiceUnavailableException;

	public List<Customer> getAllCustomer();

	public List<Customer> searchBysurname(String surname);

	public Customer getById(int id);
}
