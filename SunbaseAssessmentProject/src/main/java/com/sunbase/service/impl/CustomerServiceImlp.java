package com.sunbase.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbase.dao.CustomerDao;
import com.sunbase.entity.Customer;
import com.sunbase.service.CustomerService;

@Service
public class CustomerServiceImlp implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
		public Customer addCustomer(Customer customer) {
		Customer addedCustomer = customerDao.addCustomer(customer);
		return addedCustomer;
	}
	
	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}

	@Override
	public Customer getCustomerById(String id) {
		Customer customer = customerDao.getCustomerById(id);
		return customer;
	}
	
	@Override
	public boolean deleteCustomerById(String id) {
		return customerDao.deleteCustomerById(id);
	}
}