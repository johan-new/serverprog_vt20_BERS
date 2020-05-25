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
		Response response = client.target("http://localhost:8080/CustomerManagement/webservice/customers").request().buildGet().invoke();
		List<Customer> customers = response.readEntity(new GenericType<List<Customer>>() {});
		for (Customer c: customers ) {
			System.out.println(c);
		}
		System.out.println("\n\n");
		response.close();


		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers/Bildoktorn").request().buildGet().invoke();
		List<Customer> searchHits = response.readEntity(new GenericType<List<Customer>>() {});
		for (Customer c: searchHits ) {
			System.out.println(c);
		}
		response.close();



		Customer exampleCustomer = new Customer("Luggis","B","08-585888",
								"Stigen 1, Stockholm","After sales","gugge@lindab.com",
					"Bubbe");
		Entity customerEntity = Entity.entity(exampleCustomer, "application/XML");
		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers").request().buildPost(customerEntity).invoke();
		if (response.getStatus() == 201)
		{
			System.out.println("CREATED: " + exampleCustomer.toString());
		}
		response.close();



	}

}
