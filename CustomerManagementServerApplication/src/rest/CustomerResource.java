package rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import dao.CustomerNotFoundException;
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

	@GET    //TODO
	@Produces("application/XML")
	@Path("/id/{idParameter}")
	public Response getById(@PathParam("idParameter") int id) {
		Customer returnCustomer;
		try {
			returnCustomer = service.identifyCustomer(id);

			return Response.status(200).build(); //OK code created
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			return Response.status(404).build(); //Not found code created
		}
	}
	
	@POST
	@Produces("application/XML")
	@Consumes("application/XML")
	public Response registerCustomer(Customer customer)  {
		try {
			service.registerCustomer(customer);
			return Response.status(201).build(); //HTTP code created
		} catch (ServiceUnavailableException serviceUnavailableException) {
			serviceUnavailableException.printStackTrace();
			return Response.status(504).build();
		}
	}
}
