package domain;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import service.CustomerManagementService;

public class Main {

	public static void main(String[] args) throws NamingException {
		
		Properties jndiProperties = new Properties();

		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		jndiProperties.put("jboss.naming.client.ejb.context", true);

		Context jndi = new InitialContext(jndiProperties);

		// friendlyName MSTE fixas, men hittar ej i Wildfly :( /Erik
		CustomerManagementService service = (CustomerManagementService) jndi.lookup("CustomerManagementServerApplication/CustomerManagementServiceImplementation!service.CustomerManagementService");

		service.registerCustomer(new Customer("Bosse","Bildoktorn","07622222","Kundsgatan 1","Prospects","bosse@mail.com","Hasse Andersson"));
		service.registerCustomer(new Customer("Doktor","Åsa","076111111","Kundsgatan 2","Prospects","aasa@mail.com","Hasse Andersson"));

		List<Customer> customers = service.getAllCustomers();
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		//service.removeCustomer( 102);


	}

}
