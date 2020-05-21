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

		// friendlyName MÅSTE fixas, men hittar ej i Wildfly :( /Erik
		CustomerManagementService service = (CustomerManagementService) jndi.lookup("CustomerManagementServerApplication/CustomerManagementServiceImplementation!service.CustomerManagementService");
	
		List<Customer> customers = service.getAllCustomers();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

}
