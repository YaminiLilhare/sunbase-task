package com.sunbase.service;

import java.util.List;

import com.sunbase.entity.Customer;


public interface CustomerService {

	Customer addCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	Customer getCustomerById(String id);

	boolean deleteCustomerById(String id);

}
