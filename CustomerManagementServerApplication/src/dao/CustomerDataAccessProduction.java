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
	public Customer find(Customer customer) {
		Query q = em.createQuery("select customer from Customer customer where customer.id = :id");
		q.setParameter("id", id);
		return (Customer) q.getSingleResult();
	}

	@Override
	public void add(Customer customer) {
		em.persist(customer);

	}

	@Override
	public Customer remove(Customer customer) {
		Query q = em.createQuery("delete customer from Customer customer where customer.id = :id");
		q.setParameter("id", id);
		return q.getSingleResult();
	}

}