package service;

import java.util.List;

import javax.ejb.Stateless;

import domain.Customer;

@Stateless
public class CustomerManagementServiceImplementation implements CustomerManagementService {

	@Override
	public void registerCustomers(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> searchBysurname(String surname) {
		// TODO Auto-generated method stub
		return null;
	}

}
