package domain;

import java.io.Serializable;

public class Customer implements java.io.Serializable {

	private int id; 
	private String firstname; 
	private String surname; 
	private String phone; 
	private String address; 
	private String customergroup; 
	private String email; 
	private String accountmanager;

	
	public Customer() {
		
	}


	public Customer(String firstname, String surname, String phone, String address, String customergroup,
			String email, String accountmanager) {
		this.firstname = firstname;
		this.surname = surname;
		this.phone = phone;
		this.address = address;
		this.customergroup = customergroup;
		this.email = email;
		this.accountmanager = accountmanager;
	}


	public void Id(int id) {
		this.id = id;
	}


	public void Firstname(String firstname) {
		this.firstname = firstname;
	}


	public void Surname(String surname) {
		this.surname = surname;
	}


	public void Phone(String phone) {
		this.phone = phone;
	}


	public void Address(String address) {
		this.address = address;
	}


	public void Customergroup(String customergroup) {
		this.customergroup = customergroup;
	}


	public void Email(String email) {
		this.email = email;
	}


	public void Accountmanager(String accountmanager) {
		this.accountmanager = accountmanager;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", phone=" + phone
				+ ", address=" + address + ", customergroup=" + customergroup + ", email=" + email
				+ ", accountmanager=" + accountmanager + "]";
	}
	
	
}
