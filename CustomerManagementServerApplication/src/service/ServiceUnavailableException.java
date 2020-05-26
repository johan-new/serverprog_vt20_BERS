package service;

import javax.ejb.ApplicationException;

public class ServiceUnavailableException extends Exception {

    ServiceUnavailableException(String errorMessage) {
        super(errorMessage);
    }

}
