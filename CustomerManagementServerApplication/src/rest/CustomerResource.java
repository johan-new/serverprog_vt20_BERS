package rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;

import domain.Customer;
import service.CustomerManagementServiceLocal;
import service.ServiceUnavailableException;

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
	public List<Customer> searchBySurname(@PathParam("customerSurname") String surname) {
		return service.searchBySurname(surname);

	}
	
	@POST
	@Produces("application/XML")
	@Consumes("application/XML")
	public Customer registerCustomer(Customer customer) {
		//try {
			service.registerCustomer(customer);
		//} catch (ServiceUnavailableException e) {

		//}

		return customer;
	}
}
