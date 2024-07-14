package com.sunbase.dao;
import java.util.List;
import com.sunbase.entity.Customer;

public interface CustomerDao {
	
	Customer addCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);

	List<Customer> getAllCustomer();
	
	Customer getCustomerById(String id);
	
	boolean deleteCustomerById(String id);

}
