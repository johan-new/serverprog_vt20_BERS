package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domain.Customer;

@Stateless
@Default
@ProductionDao
public class CustomerDataAccessProduction implements CustomerDataAccess {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Customer> findAll() throws CannotReadDatabaseException{
		try{
			Query q = em.createQuery("select customer from Customer customer");
			List<Customer> customer = q.getResultList();
			return customer;
		} catch (Exception e) {
			throw new CannotReadDatabaseException("CannotReadDatabaseException findAll()@dao");
		}
	}

	@Override
	public List<Customer> find(String surname) throws CannotReadDatabaseException{
		try{
		Query q = em.createQuery("select customer from Customer customer where customer.surname = :surname");
		q.setParameter("surname", surname);
		List<Customer> customers = q.getResultList();
		return customers;
		} catch (Exception e) {
			throw new CannotReadDatabaseException("CannotReadDatabaseException find(surname)@dao");
		}
	}

	@Override
	public void add(Customer customer) throws CustomerNotCreatedException {
		try {
			em.persist(customer);
		} catch (Exception e) {
			throw new CustomerNotCreatedException("Customer not added @ DAO\n" + e.getMessage());
		}

	}
	@Override
	public void remove(int id) throws CustomerNotFoundException {
		try {
		Customer c = getById(id);
		em.remove(c);
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer not removed @ DAO\n" + e.getMessage());
		}

	}

	@Override
	public void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager) throws CustomerNotFoundException {

		try {
			Customer c = getById(id);
			
			if (newPhone != null) {
				c.setPhone(newPhone);
			}
			if (newAddress != null) {
				c.setAddress(newAddress);
			}
			if (newCustomergroup != null) {
				c.setCustomergroup(newCustomergroup);
			}
			if (newEmail != null){
				c.setEmail(newEmail);
			}
			if (newAccountmanager != null){
				c.setAccountmanager(newAccountmanager);
			}
		} catch (Exception e) {
			throw new CustomerNotFoundException("Customer not updated @ DAO\n" + e.getMessage());
		}

	}

	@Override
	public Customer getById(int id) throws CustomerNotFoundException{
		try {
		Query q = em.createQuery("select customer from Customer customer where customer.id = :id");
		q.setParameter("id", id);
		return (Customer)q.getSingleResult();
		} catch (NoResultException e) {
			throw new CustomerNotFoundException(e.getMessage());
		}
	}

}