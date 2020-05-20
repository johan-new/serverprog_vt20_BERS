package dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CustomerDataAccess {
    List<Customer> findAll();
    Customer find(Customer customer);
    Customer add(Customer customer);
    Customer remove(Customer customer);
}
