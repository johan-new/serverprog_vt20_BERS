package dao;

import domain.Customer;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
@TestingDao
public class CustomerDataAccessTesting implements CustomerDataAccess {
	
	@Override 
	public Customer add(Customer customer) {
		return null;
	}
	
	@Override
	public List<Customer> findAll() {
		Customer c1 = new Customer("Erik", "Manfredssono", "0712582225", "Vasagatan 23", "bla", "erik@mail.com", "blabla" );
		Customer c2 = new Customer("Johan", "Manfredssono", "0712582725", "Vasagatan 2", "bla", "johan@mail.com", "blabla" );
		Customer c3 = new Customer("Simon", "Manfredssono", "0712582425", "Vasagatan 44", "bla", "simon@mail.com", "blabla" );
		List<Customer> customer = new ArrayList<Customer>();
		customer.add(c1);
		customer.add(c2); 
		customer.add(c3); 
		return null;
	}
	@Override
	public List<Customer> find(String surname) {
		return null; 
	}

	@Override
	public void remove(Customer customer) {
		// TODO Auto-generated method stub
	}




}
