package dao;

import javax.ejb.Local;

import domain.Customer;

import java.util.List;

@Local
public interface CustomerDataAccess {
    List<Customer> findAll() throws CannotReadDatabaseException;
    List<Customer> find(String surname) throws CannotReadDatabaseException;
    void add(Customer customer) throws CustomerNotCreatedException;
    void remove(int id) throws CustomerNotFoundException;
    void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager) throws CustomerNotFoundException;
    Customer getById(int id) throws CustomerNotFoundException;
}
