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


		//service.removeCustomer( 102);

		//Customer aasa = service.identifyCustomer(106);
		//service.updateCustomer(106,"112",aasa.getAddress(),aasa.getCustomergroup(),aasa.getEmail(),aasa.getAccountmanager());

		service.updatePhoneNr(106,"0");
		service.updateAccountmanager(106,"Percy Nilegård");
		service.updateAddress(106,"Testgatan 1337");
		service.updateEmail(106,"dr_haxx@gmail.com");

		List<Customer> customers = service.getAllCustomers();

		for (Customer customer : customers) {
			System.out.println(customer);
		}


	}

}
