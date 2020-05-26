package dao;
import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class CannotReadDatabaseException extends Exception{
    CannotReadDatabaseException(String errorMessage){
        System.err.println(errorMessage + "\n Performing rollback...");
    }
}
