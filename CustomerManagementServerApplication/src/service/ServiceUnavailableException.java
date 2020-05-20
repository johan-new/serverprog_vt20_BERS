package service;

public class ServiceUnavailableException extends Exception {

    ServiceUnavailableException(String errorMessage) {
        super(errorMessage);
    }

}
