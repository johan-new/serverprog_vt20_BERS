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
    
 // ADD RETURN STATEMENT, BEÖHVER VI DET????
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
// ADD RETURN STATEMENT, BEÖHVER VI DET????
    @Override
    public Customer removeCustomer(int id) {
    	dao.remove(id);
        return null;
    }

}
