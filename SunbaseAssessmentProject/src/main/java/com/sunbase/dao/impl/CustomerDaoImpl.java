package com.sunbase.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.sunbase.dao.CustomerDao;
import com.sunbase.entity.Customer;


@Component
public class CustomerDaoImpl implements CustomerDao{

	  @Autowired
	    private SessionFactory sf;

	@Override
	public Customer addCustomer(Customer customer) {
		Session session = null;
        boolean isAdded = false;
        try {
            session = sf.openSession();
            session.save(customer);
            session.beginTransaction().commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isAdded==true) {
			return customer;
		} else {
			return null;
		}

	}

	@Override
	public Customer updateCustomer(Customer customer) {

		Session session = null;
		Customer presentCustomer = null;

		try {
			session = sf.openSession();
			Customer pcustomer = getCustomerById(customer.getId());
			if (pcustomer != null) {
				session.update(customer);
				session.beginTransaction().commit();
				return customer;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return presentCustomer;
	}
	
	@Override
	public List<Customer> getAllCustomer() {
		Session session = null;
		List<Customer> list = new ArrayList<>();

		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Customer.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Customer getCustomerById(String id) {

		Session session = null;
		Customer customer = null;

		try {
			session = sf.openSession();
			customer = session.get(Customer.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return customer;
	}
	
	@Override
	public boolean deleteCustomerById(String id) {

		Session session = null;
		boolean isDeleted = false;

		try {

			session = sf.openSession();
			Customer presentCustomer = session.get(Customer.class, id);
			if (presentCustomer != null) {
				session.delete(presentCustomer);
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

}
