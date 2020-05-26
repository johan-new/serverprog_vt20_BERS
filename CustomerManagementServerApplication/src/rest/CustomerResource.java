package rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Link;
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

	@GET //FIX LATER @HANDLEDNING
	@Produces("application/XML")
	@Path("/id/{idParameter}")
	public Response getById(@PathParam("idParameter") int id) {
		Customer returnCustomer;
		try {
			returnCustomer = service.identifyCustomer(id);
			Link directURI = Link.fromUri("/customers/" + id).rel("self").type("get").build();

			//return Response(returnCustomer).links(directURI).build();
			return Response.status(200).build(); //OK code created
		} catch (CustomerNotFoundException e) {
			e.printStackTrace();
			return Response.status(404).build(); //Not found code created
		}
	}
	
	@GET
	@Produces("application/XML")
	@Path("{customerNo}")
	public Response findCustomerById(@PathParam("customerNo") int id) {	
		try {
			Customer result = service.identifyCustomer(id);
			Link selfLink= Link.fromUri("/customers/" + id).rel("self").type("get").build();
			Link updateLink= Link.fromUri("/customers/" + id).rel("update").type("put").build();
			Link deleteLink= Link.fromUri("/customers/" + id).rel("delete").type("delete").build();
			return Response.ok(result).links(selfLink,updateLink,deleteLink).build();
		}catch (CustomerNotFoundException e) {
			return Response.status(404).build();
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
