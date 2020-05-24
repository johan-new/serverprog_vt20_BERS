package domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer implements java.io.Serializable {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
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


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCustomergroup(String customergroup) {
		this.customergroup = customergroup;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccountmanager(String accountmanager) {
		this.accountmanager = accountmanager;
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


	public int id() {
		return this.id;
	}


	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getSurname() {
		return surname;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public String getCustomergroup() {
		return customergroup;
	}

	public String getEmail() {
		return email;
	}

	public String getAccountmanager() {
		return accountmanager;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", phone=" + phone
				+ ", address=" + address + ", customergroup=" + customergroup + ", email=" + email
				+ ", accountmanager=" + accountmanager + "]";
	}
	
	
}
