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

		Customer exampleCustomer = new Customer("Linda","B","08-555777444",
								"Gränden 1, Stockholm","After sales","manager@lindab.com",
					"Bubbe");
		Entity customerEntity = Entity.entity(exampleCustomer, "application/XML");
		response = client.target("http://localhost:8080/CustomerManagement/webservice/customers").request().buildPost(customerEntity).invoke();
		response.close();

		/*
		Employee ben = new Employee();
		ben.setFirstName("Ben");
		ben.setSurname("Red");
		ben.setJobRole("Tester");
		ben.setSalary(1000);

		Entity benEntity = Entity.entity(ben, "application/XML");

		response = client.target("http://localhost:8080/EmployeeManagement/webservice/employees")
				.request().buildPost(benEntity).invoke();
		System.out.println(response.readEntity(Employee.class).getId());
		response.close();
		*
		* */

	}

}
