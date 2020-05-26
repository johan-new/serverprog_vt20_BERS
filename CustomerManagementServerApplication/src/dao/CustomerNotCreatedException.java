package dao;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class CustomerNotCreatedException extends Exception {

        CustomerNotCreatedException(String errorMessage){
            System.err.println(errorMessage + "\n Performing rollback...");
        }


}
