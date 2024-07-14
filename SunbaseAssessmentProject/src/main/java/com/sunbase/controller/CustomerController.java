package com.sunbase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbase.entity.Customer;
import com.sunbase.exception.ResourceAlreadyExistsException;
import com.sunbase.exception.ResourceNotFoundException;
import com.sunbase.service.CustomerService;




/**
 * @author Yamini
 *
 */
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping(value = "/add-customer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

		Customer addedCustomer = customerService.addCustomer(customer);

		if (addedCustomer != null) {
			  System.out.println("Added Admitted :" + addedCustomer);
			return new ResponseEntity<>(addedCustomer, HttpStatus.CREATED);
		} else {
			System.out.println("Customer Already Exixts With >ID:" + customer.getId());
			throw new ResourceAlreadyExistsException("Customer Already Exixts With >ID: " + customer.getId());
		}
	}
	
	@PutMapping(value = "/update-customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {

		Customer updatedCustomer = customerService.updateCustomer(customer);
		String msg = "";
		if (updatedCustomer != null) {
			System.out.println("Customer updated successfully and patient details is " + updatedCustomer);
			msg = "Customer updated successfully";
		} else {
			System.out.println("Customer failed to updated and Customer details is " + customer);
			msg = "Customer failed to update";
		}
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@GetMapping(value = "/get-all-customer")
	public ResponseEntity<List<Customer>> getAllCustomer() {

		List<Customer> listOfCustomer = customerService.getAllCustomer();

		if (listOfCustomer.isEmpty()) {
			System.out.println("Customer not found");
			throw new ResourceNotFoundException("Customer not found");
		} else {
			System.out.println("Get all Customer.");
			return new ResponseEntity<List<Customer>>(listOfCustomer, HttpStatus.OK);
		}

	}
	
	@GetMapping(value = "/get-customer-by-id/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {

		Customer customer = customerService.getCustomerById(id);

		if (customer != null) {
			System.out.println("Get Customer by Id : " + id);
			return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		} else {
			System.out.println("Customer not found by ID : " + id);
			throw new ResourceNotFoundException("Customer not found with >ID: " + id);
		}

	}

	@DeleteMapping(value = "/delete-customer-by-id/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable String id) {

		boolean deletedCustomer = customerService.deleteCustomerById(id);
		if (deletedCustomer) {
			System.out.println("Customer deleted successfully");
			return new ResponseEntity<String>("Customer deleted successfully", HttpStatus.OK);
		} else {
			System.out.println("Something went to wrong Customer not deleted with id : " + id);
			throw new ResourceNotFoundException("Customer not found with >ID: " + id);
		}

	}
}

