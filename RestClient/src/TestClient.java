import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
* TestClient - REST API
*
* Parameters are hard-coded. Uncomment the relevant blocks of the code.
*
* Please see project README for more information.
*
 * @version 1.0
 * @author Erik Manfredsson, Simon Södergren, Johan Nyberg
 *
 * */

public class TestClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		Response response;



		// DELETE CUSTOMER
		/*
		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers/208").request()
				.buildDelete().invoke();
		System.out.println(response.getHeaders().toString());
		System.out.println("DELETE CUSTOMER:\tStatus code " + response.getStatus());
		response.close();*/


		// UPDATE CUSTOMER
		/*
		Customer updatedCustomer = new Customer("Uppdaterad", "Eriksson", "010 111111", "Uppdaterad 123", "Premium", "epost@epost.se", "Perra");
		Entity eEntity = Entity.entity(updatedCustomer, "application/JSON");
		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers/301").request().buildPut(eEntity).invoke();
		
		System.out.println(response.getHeaders().toString());
		System.out.println("UPDATE CUSTOMER:\tStatus code " + response.getStatus());
		System.out.println(response.readEntity(String.class));

		response.close();
		*/


		// ADD CUSTOMER
		/*
		Customer exampleCustomer = new Customer("NYALuggis","Bytenstein","08-585888",
								"Stigen 1, Stockholm","After sales","gugge@lindab.com",
					"Bubbe");
		Entity customerEntity = Entity.entity(exampleCustomer, "application/JSON");
		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers").request().buildPost(customerEntity).invoke();
		System.out.println(response.getHeaders().toString());
		System.out.println("ADD CUSTOMER:\tStatus code " + response.getStatus());
		response.close();*/


		// GET SPECIFIC CUSTOMER
		/*
		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers/id/2").request("application/JSON").buildGet().invoke();
		Customer searchHit = response.readEntity(Customer.class);
		System.out.println(searchHit);
		System.out.println(response.getHeaders().toString());
		System.out.println("GET SPECIFIC CUSTOMER:\tStatus code " + response.getStatus());
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
