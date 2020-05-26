package dao;
import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class CustomerNotFoundException extends Exception {
    CustomerNotFoundException(String errorMessage){
        System.err.println(errorMessage + "\n Performing rollback...");
    }
}
