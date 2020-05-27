package service;

import java.util.List;

import dao.CannotReadDatabaseException;
import dao.CustomerDataAccess;
import dao.CustomerNotFoundException;
import dao.CustomerNotCreatedException;
import domain.Customer;

import javax.ejb.Stateless;
import javax.inject.Inject;


@Stateless
public class CustomerManagementServiceImplementation implements CustomerManagementService, CustomerManagementServiceLocal {

    @Inject
    private CustomerDataAccess dao;
    
 // ADD RETURN STATEMENT, BE�HVER VI DET????
    @Override
    public List<Customer> getAllCustomers() throws CannotReadDatabaseException {
        return dao.findAll();
    }

    @Override
    public List<Customer> searchBySurname(String surname) throws CannotReadDatabaseException {
        return dao.find(surname);
    }

    @Override
    public void registerCustomer(Customer customer) throws ServiceUnavailableException {
        try {
            dao.add(customer);
        } catch (CustomerNotCreatedException e) {
            throw new ServiceUnavailableException(e.getMessage());
        }

    }

    @Override
    public void removeCustomer(int id) throws CustomerNotFoundException {
    	dao.remove(id);
    }

    @Override
    public Customer identifyCustomer(int id) throws CustomerNotFoundException {
        return dao.getById(id);
    }

    @Override //    NEW COMPARING IMPLEMENTATION AT CUSTOMER OBJECT MIGHT BE REQUIRED
    public int identifyCustomer(Customer customer) throws CustomerNotFoundException, CannotReadDatabaseException {

        List<Customer> allCustomers = getAllCustomers();

        for (Customer c : allCustomers ) {
            if (customer.equals(c))      {
                return c.getId();
            }      else {
                throw new CustomerNotFoundException("CustomerNotFoundException identifyCustomer(customer) @ DAO ");
            }
        }

        return -1;
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
