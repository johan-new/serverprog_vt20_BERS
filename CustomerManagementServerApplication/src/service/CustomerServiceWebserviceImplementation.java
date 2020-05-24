package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

import domain.Customer;

@Stateless
@WebService(name = "CustomerManagementWebService")
public class CustomerServiceWebserviceImplementation {

	@Inject
	private CustomerManagementServiceLocal service;

	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}

	public Customer identifyCustomer(int id) {
		return service.identifyCustomer(id);
	}

	public void registerCustomer(Customer customer) {
		service.registerCustomer(customer);
	}

	public void removeCustomer(int id) {
		service.removeCustomer(id);
	}

	public List<Customer> searchBySurname(String surname) {
		return service.searchBySurname(surname);
	}

	public void updateAccountManager(int id, String newAccountManager) {
		service.updateAccountmanager(id, newAccountManager);
	}

	public void updateAddress(int id, String newAddress) {
		service.updateAddress(id, newAddress);
	}

	public void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail,
			String newAccountmanager) {
		service.updateCustomer(id, newPhone, newAddress, newCustomergroup, newEmail, newAccountmanager);
	}

	public void updateCustomergroup(int id, String newCustomergroup) {
		service.updateCustomergroup(id, newCustomergroup);
	}

	public void updateEmail(int id, String newEmail) {
		service.updateEmail(id, newEmail);
	}

	public void updatePhoneNr(int id, String newNr) {
		service.updatePhoneNr(id, newNr);
	}
}
