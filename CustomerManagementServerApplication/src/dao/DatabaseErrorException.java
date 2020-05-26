package dao;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class DatabaseErrorException extends Exception {

        DatabaseErrorException(String errorMessage){
            System.err.println(errorMessage + "\n Performing rollback...");
        }


}
