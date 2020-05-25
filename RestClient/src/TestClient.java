import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

public class TestClient {

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		Response response = client.target("http://localhost:8080/CustomerManagement/webservice/customers/Eriksson").request().buildGet().invoke();
		Customer customer = (Customer)response.readEntity(Customer.class);
		System.out.println(customer);
		response.close();
	}

}
