package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import domain.Customer;
import service.CustomerManagementServiceLocal;

@Stateless
@Path("/customers")
public class CustomerResource {

	@Inject
	private CustomerManagementServiceLocal service;
	
	@GET
	@Produces("application/XML")
	public List<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}
	
	@GET
	@Produces("application/XML")
	@Path("{customerSurname}")
	public Customer findEmployeeById(@PathParam("customerSurname") String surname) {
		return (Customer) service.searchBySurname(surname);
	}
}
