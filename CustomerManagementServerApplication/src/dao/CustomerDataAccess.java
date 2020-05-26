package dao;

import javax.ejb.Local;

import domain.Customer;

import java.util.List;

@Local
public interface CustomerDataAccess {
    List<Customer> findAll();
    List<Customer> find(String surname);
    void add(Customer customer) throws DatabaseErrorException;
    void remove(int id) throws CustomerNotFoundException;
    void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager) throws CustomerNotFoundException;
    Customer getById(int id) throws CustomerNotFoundException;
}
