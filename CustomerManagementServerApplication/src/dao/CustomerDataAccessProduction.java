package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
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
// RETURNERA ANNAT �N NULL H�R? BEH�VER VI ENS RETURN?
	@Override
	public Customer add(Customer customer) {
		em.persist(customer);
		return null;
	}
	@Override
	public void remove(Customer customer) {
		em.remove(customer);
	}


}