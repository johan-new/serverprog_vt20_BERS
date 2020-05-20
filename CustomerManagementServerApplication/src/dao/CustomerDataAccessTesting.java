package dao;

import domain.Customer; 

@Stateles
@TestingDao
public class CustomerDataAccessTesting implements CustomerDataAccess {
	
	@Override 
	public void insert(Customer newCustomer) {
		
	}
	
	@Override
	public List<Customer> findAll() {
		Customer c1 = new Customer(1, "Erik", "Manfredssono", "0712582225", "Vasagatan 23", "bla", "erik@mail.com", "blabla" );
		Customer c2 = new Customer(2, "Johan", "Manfredssono", "0712582725", "Vasagatan 2", "bla", "johan@mail.com", "blabla" );
		Customer c3 = new Customer(3, "Simon", "Manfredssono", "0712582425", "Vasagatan 44", "bla", "simon@mail.com", "blabla" );
		List<Customer> customer = new ArrayList<Customer>();
		customer.add(c1);
		customer.add(c2); 
		customer.add(c3); 

	}
	@Override
	public List<Customer> findBySurname(String surname) {
		return null; 
	}

}
