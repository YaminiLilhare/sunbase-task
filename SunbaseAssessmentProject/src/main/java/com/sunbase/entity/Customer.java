package com.sunbase.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 * @author Yamini
 *
 */
@Entity
public class Customer {

	@Id
	@Column(name = "customer_id" ,nullable = false,length = 64)
	private String id;

	@Column(name = "first_name",nullable = false,length = 255)
	@NotBlank(message = "FirstName Is Required")
	private String firstName;

	@Column(name = "last_name",nullable = false,length = 255)
	@NotBlank(message = "LastName Is Required")
	private String lastName;
	
	@Column(name = "street",length = 255)
	private String street;
	
	@Column(name = "address",length = 255)
	private String address;
	
	@Column(name = "city",nullable = false,length = 255)
	@NotBlank(message = "City Is Required")
	private String city;
	
	@Column(name = "state",nullable = false,length = 255)
	@NotBlank(message = "State Is Required")
	private String state;

	@Column(name = "email",length = 255)
	@NotBlank(message = "EmailId Is Required")
	private String emailId;

	@Column(name = "mobile",nullable = false,length = 255)
	@NotBlank(message = "MobileNo Is Required")
	private String mobileNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", street=" + street
				+ ", address=" + address + ", city=" + city + ", state=" + state + ", emailId=" + emailId
				+ ", mobileNo=" + mobileNo + "]";
	}

	
	}