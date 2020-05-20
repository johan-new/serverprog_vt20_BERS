package domain;

import java.io.Serializable;

public class Customer implements Serializable {

//	@Id 
//	@GeneratedValue(strategy = GenerationType.AUTO); 
	private int id; 
	private String firstname; 
	private String surname; 
	private String phone; 
	private String address; 
	private String customergroup; 
	private String email; 
	private String responsibleseller;

	
	public Customer() {
		
	}


	public Customer(int id, String firstname, String surname, String phone, String address, String customergroup,
			String email, String responsibleseller) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.surname = surname;
		this.phone = phone;
		this.address = address;
		this.customergroup = customergroup;
		this.email = email;
		this.responsibleseller = responsibleseller;
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


	public void Responsibleseller(String responsibleseller) {
		this.responsibleseller = responsibleseller;
	}


	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", surname=" + surname + ", phone=" + phone
				+ ", address=" + address + ", customergroup=" + customergroup + ", email=" + email
				+ ", responsibleseller=" + responsibleseller + "]";
	}
	
	
}
