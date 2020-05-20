package dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CustomerDataAccess {
    List<Customer> findAll();
    List<Customer> find(String surname);
    Customer add(Customer customer);
    Customer remove(Customer customer);
}
