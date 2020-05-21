package dao;

import javax.ejb.Local;

import domain.Customer;

import java.util.List;

@Local
public interface CustomerDataAccess {
    List<Customer> findAll();
    List<Customer> find(String surname);
    Customer add(Customer customer);
    Customer remove(int id);
}
