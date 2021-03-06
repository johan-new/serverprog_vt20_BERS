package dao;

import domain.Customer;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

@Stateless
//@Alternative
@TestingDao
public class CustomerDataAccessTesting implements CustomerDataAccess {
	
	@Override 
	public void add(Customer customer) throws CustomerNotCreatedException {

	}
	
	@Override
	public List<Customer> findAll() {
		Customer c1 = new Customer("Erik", "Manfredssono", "0712582225", "Vasagatan 23", "bla", "erik@mail.com", "blabla" );
		Customer c2 = new Customer("Johan", "Manfredssono", "0712582725", "Vasagatan 2", "bla", "johan@mail.com", "blabla" );
		Customer c3 = new Customer("Simon", "Manfredssono", "0712582425", "Vasagatan 44", "bla", "simon@mail.com", "blabla" );
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c1);
		customers.add(c2);
		customers.add(c3);
		return customers;
	}

	@Override
	public List<Customer> find(String surname) {
		Customer c = new Customer("Simon", "Manfredssono", "0712582425", "Vasagatan 44", "bla", "simon@mail.com", "blabla" );
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(c);
		return customers;
	}

	@Override
	public void remove(int id) {
		System.out.println("TESTING DAO: REMOVE CUSTOMER #" + id);
	}

	@Override
	public void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager) {
		System.out.println("TESTING DAO: UPDATE CUSTOMER #" + id);
	}

	@Override
	public Customer getById(int id) {
		return new Customer("Simon", "Manfredssono", "0712582425", "Vasagatan 44", "bla", "simon@mail.com", "blabla" );
	}


}
