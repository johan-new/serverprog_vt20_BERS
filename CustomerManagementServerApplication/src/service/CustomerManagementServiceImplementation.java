package service;

import java.util.List;
import dao.CustomerDataAccess;
import domain.Customer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import service.ServiceUnavailableException;


@Stateless
public class CustomerManagementServiceImplementation implements CustomerManagementService {

    @Inject
    private CustomerDataAccess dao;
    
 // ADD RETURN STATEMENT, BE�HVER VI DET????
    @Override
    public List<Customer> getAllCustomers() {
        return dao.findAll();
    }

    @Override
    public List<Customer> searchBySurname(String surname) {
        return dao.find(surname);
    }

    @Override
    public void registerCustomer(Customer customer) throws ServiceUnavailableException {
        dao.add(customer);
    }
// ADD RETURN STATEMENT, BE�HVER VI DET????
    @Override
    public void removeCustomer(int id) {
    	dao.remove(identifyCustomer(id));
    }

    @Override
    public Customer identifyCustomer(int id) {
        List<Customer> allCustomers = getAllCustomers();

        for (int i = 0; i < allCustomers.size(); i++) {
            if (id == allCustomers.get(i).id() ) {
                return allCustomers.get(i); // search hit
            }
        }

        return null; //no hit
    }

}
