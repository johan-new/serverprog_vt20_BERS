package service;

import CustomerManagementService;
import dao.CustomerDataAccess;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class CustomerManagementServiceImplementation implements CustomerManagementService {

    @Inject
    private CustomerDataAccess dao;

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

    @Override
    public removeCustomer(Customer customer) {
        dao.remove(customer);
    }

}
