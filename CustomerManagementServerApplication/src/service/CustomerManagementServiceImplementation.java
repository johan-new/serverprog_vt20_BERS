package service;

import java.util.List;
import dao.CustomerDataAccess;
import dao.CustomerNotFoundException;
import domain.Customer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import service.ServiceUnavailableException;


@Stateless
public class CustomerManagementServiceImplementation implements CustomerManagementService, CustomerManagementServiceLocal {

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
    public void registerCustomer(Customer customer) {
        dao.add(customer);
    }

    @Override
    public void removeCustomer(int id) throws CustomerNotFoundException {
    	dao.remove(identifyCustomer(id));
    }

    @Override
    public Customer identifyCustomer(int id) throws CustomerNotFoundException {
        return dao.getById(id);
    }

    @Override
    public void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager) throws CustomerNotFoundException {
        dao.updateCustomer(id,newPhone,newAddress,newCustomergroup,newEmail,newAccountmanager);
    }

    @Override
    public void updatePhoneNr(int id, String newNr) throws CustomerNotFoundException {
        dao.updateCustomer(id, newNr,null,null,null,null);
    }

    @Override
    public void updateAddress(int id, String newAddress) throws CustomerNotFoundException {
        dao.updateCustomer(id, null,newAddress,null,null,null);
    }

    @Override
    public void updateCustomergroup(int id, String newCustomergroup) throws CustomerNotFoundException {
        dao.updateCustomer(id, null,null,newCustomergroup,null,null);
    }

    @Override
    public void updateEmail(int id, String newEmail) throws CustomerNotFoundException {
        dao.updateCustomer(id, null,null,null,newEmail,null);
    }

    @Override
    public void updateAccountmanager(int id, String newAccountManager) throws CustomerNotFoundException {
        dao.updateCustomer(id, null,null,null,null,newAccountManager);
    }

}
