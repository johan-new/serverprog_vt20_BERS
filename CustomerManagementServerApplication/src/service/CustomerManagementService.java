package service;

import javax.ejb.Remote;

import service.CustomerManagementServiceLocal;

@Remote
public interface CustomerManagementService extends CustomerManagementServiceLocal {

}