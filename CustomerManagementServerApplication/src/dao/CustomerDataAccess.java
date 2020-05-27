package dao;

import javax.ejb.Local;

import domain.Customer;

import java.util.List;

/**
 * <h2>CustomerDataAccess Interfaced</h2>
 * <p> Layer handling  database CRUD operations</p>
 * @version 1.0
 * @author Erik Manfredsson, Simon Södergren, Johan Nyberg
 */

@Local
public interface CustomerDataAccess {
    List<Customer> findAll() throws CannotReadDatabaseException;
    List<Customer> find(String surname) throws CannotReadDatabaseException;
    void add(Customer customer) throws CustomerNotCreatedException;
    void remove(int id) throws CustomerNotFoundException;
    void updateCustomer(int id, String newPhone, String newAddress, String newCustomergroup, String newEmail, String newAccountmanager) throws CustomerNotFoundException;
    Customer getById(int id) throws CustomerNotFoundException;
}
