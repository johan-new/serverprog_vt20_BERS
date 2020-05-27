package rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.CannotReadDatabaseException;
import dao.CustomerNotFoundException;
import domain.Customer;
import service.CustomerManagementServiceLocal;
import service.ServiceUnavailableException;

/**
 * <h2>REST API Resource class</h2> </ br>
 * Handling endpoints </ br>
 * <p>
 * <h3>GET</h3>
 * <ul>
 *     <li>"/" - gets all customers</li>
 *     <li>"/AnyGivenSurname - gets all customers with matching surname "AnyGivenSurname"</li>
 *     <li>"/id/7 - get customer with id 7<</li>
 * </ul>
 * </p>
 * <p>
 * <h3>POST</h3>
 * <ul>
 *     <li>"/" - registers a customer</li>
 * </ul>
 * </p>
 * <p>
 * <h3>DELETE</h3>
 * <ul>
 *     <li>"/" - deletes a customer</li>
 * </ul>
 * </p>
 * <p>
 * <h3>PUT</h3>
 * <ul>
 *     <li>"/" - alters a customers data (NOT NAME)</li>
 * </ul>
 * </p>
 *
 * @version 1.0
 * @author Erik Manfredsson, Simon Södergren, Johan Nyberg
 */

@Stateless
@Path("/customers")
public class CustomerResource {

	@Inject
	private CustomerManagementServiceLocal service;

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response getAllCustomers() {
		try {
			//List<Customer> customers = service.getAllCustomers();
			return Response.ok(service.getAllCustomers()).build();
		} catch (CannotReadDatabaseException e) {
			e.printStackTrace();
			return Response.status(404).build();
		}
	}

	@GET
	@Produces("application/XML")
	@Path("{customerSurname}")
	public Response searchBySurname(@PathParam("customerSurname") String surname) {
		try {
			List<Customer> searchHits = service.searchBySurname(surname);
			return Response.ok(searchHits).build();
		} catch (CannotReadDatabaseException e) {
			e.printStackTrace();
			return Response.status(404).build();
		}


	}

	@GET //FIX LATER @HANDLEDNING
	@Produces("application/XML")
	@Path("/id/{idParameter}")
	public Response getById(@PathParam("idParameter") int id) {
		Customer returnCustomer;
		try {
			returnCustomer = service.identifyCustomer(id);
			return Response.ok(returnCustomer).build();
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

	@DELETE
	@Path("{customerNo}")
	public Response removeCustomer(@PathParam("customerNo") int id) {
		try {
			service.removeCustomer(id);
			return Response.status(204).build();
		} catch (CustomerNotFoundException e) {
			return Response.status(404).build();
		}
	}

	@PUT
	@Path("{customerNo}")
	@Produces({ "application/XML" })
	@Consumes({ "application/XML" })
	public Response updateCustomer(@PathParam("customerNo") int id, Customer c) {
		try {
			service.updateCustomer(id, c.getPhone(), c.getAddress(), c.getCustomergroup(), c.getEmail(),
					c.getAccountmanager());
			return Response.status(200).build();
		} catch (CustomerNotFoundException e) {
			return Response.status(404).build();
		}
	}

}
