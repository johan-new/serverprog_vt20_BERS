package service;

import java.util.List;

import javax.ejb.Remote;

import domain.Customer;

@Remote
public interface CustomerManagementService {

	void registerCustomer(Customer customer);

	List<Customer> getAllCustomers();

	List<Customer> searchBySurname(String surname);

	void removeCustomer(int id);

	Customer identifyCustomer(int id);

	void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager);

	void updatePhoneNr(int id, String newNr);

	void updateAddress(int id, String newAddress);

	void updateCustomergroup(int id, String newCustomergroup);

	void updateEmail(int id, String newEmail);

	void updateAccountmanager(int id, String newAccountManager);
}