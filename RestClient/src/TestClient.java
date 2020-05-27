import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class TestClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		Response response;

/*

		// DELETE
		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers/302").request()
				.buildDelete().invoke();
		System.out.println("Delete status was " + response.getStatus());
		response.close();

		// UPDATE CUSTOMER
		Customer updatedCustomer = new Customer("Erik", "Eriksson", "010 111111", "Hejgatan 123", "Premium", "epost@epost.se", "Perra");
		Entity eEntity = Entity.entity(updatedCustomer, "application/XML");
		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers/2").request().buildPut(eEntity).invoke();
		
		System.out.println(response.getHeaders().toString());
		System.out.println("Status code" + response.getStatus());
		System.out.println(response.readEntity(String.class));

		response.close();
			*/


		// LÄGGA TILL
/*
		Customer exampleCustomer = new Customer("Luggis","Bytenstein","08-585888",
								"Stigen 1, Stockholm","After sales","gugge@lindab.com",
					"Bubbe");
		Entity customerEntity = Entity.entity(exampleCustomer, "application/XML");
		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers").request().buildPost(customerEntity).invoke();
		System.out.println(response.getHeaders().toString());
		System.out.println("Status code" + response.getStatus());
		response.close();*/


		// GET ALL CUSTOMERS

		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers").request("application/JSON").buildGet().invoke();
		List<Customer> searchHits = response.readEntity(new GenericType<List<Customer>>() {});
		for (Customer c : searchHits) {
			System.out.println(c);
		}
		System.out.println(response.getHeaders().toString());
		System.out.println("Status code" + response.getStatus());
		response.close();

	}

}
