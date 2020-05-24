package service;

import java.util.List;

public class SoapClientTest {

	public static void main(String[] args) {

		CustomerManagementWebService service = new CustomerServiceWebserviceImplementationService().getCustomerManagementWebServicePort();
		
		List<Customer> customers = service.getAllCustomers();
		
		for(Customer customer: customers) {
			System.out.println(customer.getAccountmanager());
		}
		
		List<Customer> customer13 = service.searchBySurname("Eriksson");
		for(Customer customer: customer13) {
			System.out.println(customer.getAddress());
		}
	}

}
