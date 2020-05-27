package service;

import java.util.List;

import javax.ejb.Local;

import dao.CannotReadDatabaseException;
import dao.CustomerNotFoundException;
import domain.Customer;

/**
 * <h2>CustomerManagementServiceLocal Interface</h2>
 * <p> Service layer. Uses: create, read, update any particular info (aside from name - a feature not a bug n.b.), and delete customers. </p>
 * @version 1.0
 * @author Erik Manfredsson, Simon Södergren, Johan Nyberg
 */

@Local
public interface CustomerManagementServiceLocal {

	void registerCustomer(Customer customer) throws ServiceUnavailableException;

	List<Customer> getAllCustomers() throws CannotReadDatabaseException;

	List<Customer> searchBySurname(String surname) throws CannotReadDatabaseException;

	void removeCustomer(int id) throws CustomerNotFoundException;

	Customer identifyCustomer(int id) throws CustomerNotFoundException;

	int identifyCustomer(Customer customer) throws CustomerNotFoundException, CannotReadDatabaseException;

	void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager) throws CustomerNotFoundException ;

	void updatePhoneNr(int id, String newNr) throws CustomerNotFoundException ;

	void updateAddress(int id, String newAddress) throws CustomerNotFoundException ;

	void updateCustomergroup(int id, String newCustomergroup) throws CustomerNotFoundException ;

	void updateEmail(int id, String newEmail) throws CustomerNotFoundException ;

	void updateAccountmanager(int id, String newAccountManager) throws CustomerNotFoundException ;
}
