package service;

import java.util.List;

import javax.ejb.Local;

import dao.CustomerNotFoundException;
import domain.Customer;

@Local
public interface CustomerManagementServiceLocal {

	void registerCustomer(Customer customer) throws ServiceUnavailableException;

	List<Customer> getAllCustomers();

	List<Customer> searchBySurname(String surname);

	void removeCustomer(int id) throws CustomerNotFoundException;

	Customer identifyCustomer(int id) throws CustomerNotFoundException;

	int identifyCustomer(Customer customer) throws CustomerNotFoundException;

	void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager) throws CustomerNotFoundException ;

	void updatePhoneNr(int id, String newNr) throws CustomerNotFoundException ;

	void updateAddress(int id, String newAddress) throws CustomerNotFoundException ;

	void updateCustomergroup(int id, String newCustomergroup) throws CustomerNotFoundException ;

	void updateEmail(int id, String newEmail) throws CustomerNotFoundException ;

	void updateAccountmanager(int id, String newAccountManager) throws CustomerNotFoundException ;
}
