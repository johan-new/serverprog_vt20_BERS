package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Customer;
import service.ServiceUnavailableException;

@Stateless
@Default
@ProductionDao
public class CustomerDataAccessProduction implements CustomerDataAccess {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Customer> findAll() {
		Query q = em.createQuery("select customer from Customer customer");
		List<Customer> customer = q.getResultList();
		return customer;
	}

	@Override
	public List<Customer> find(String surname) {
		Query q = em.createQuery("select customer from Customer customer where customer.surname = :surname");
		q.setParameter("surname", surname);
		List<Customer> customers = q.getResultList();
		return customers;
		
	}

	@Override
	public void add(Customer customer) throws DatabaseErrorException{
		try {
			em.persist(customer);
		} catch (Exception e) {
			throw new DatabaseErrorException("Customer not added\n" + e.getMessage());
		}

	}
	@Override
	public void remove(int id) throws CustomerNotFoundException {
		Customer c = getById(id);
		em.remove(c);
	}

	private String phone;
	private String address;
	private String customergroup;
	private String email;
	private String accountmanager;

	@Override
	public void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager) throws CustomerNotFoundException {
		Customer c = getById(id);

		if (newPhone != null)
			c.setPhone(newPhone);

		if (newAddress != null)
			c.setAddress(newAddress);

		if (newCustomergroup != null)
			c.setCustomergroup(newCustomergroup);

		if (newEmail != null)
			c.setEmail(newEmail);

		if (newAccountmanager != null)
			c.setAccountmanager(newAccountmanager);
	}

	@Override
	public Customer getById(int id) throws CustomerNotFoundException{
		try {
		Query q = em.createQuery("select customer from Customer customer where customer.id = :id");
		q.setParameter("id", id);
		return (Customer)q.getSingleResult();
		} catch (NoResultException e) {
			throw new CustomerNotFoundException();
		}
	}

}