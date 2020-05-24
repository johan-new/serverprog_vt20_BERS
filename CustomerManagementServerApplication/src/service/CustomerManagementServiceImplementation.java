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
    public void registerCustomer(Customer customer) {
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

    @Override
    public void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager){
        dao.updateCustomer(id,newPhone,newAddress,newCustomergroup,newEmail,newAccountmanager);
    }

    @Override
    public void updatePhoneNr(int id, String newNr) {
        dao.updateCustomer(id, newNr,null,null,null,null);
    }

    @Override
    public void updateAddress(int id, String newAddress) {
        dao.updateCustomer(id, null,newAddress,null,null,null);
    }

    @Override
    public void updateCustomergroup(int id, String newCustomergroup) {
        dao.updateCustomer(id, null,null,newCustomergroup,null,null);
    }

    @Override
    public void updateEmail(int id, String newEmail) {
        dao.updateCustomer(id, null,null,null,newEmail,null);
    }

    @Override
    public void updateAccountmanager(int id, String newAccountManager) {
        dao.updateCustomer(id, null,null,null,null,newAccountManager);
    }

}
