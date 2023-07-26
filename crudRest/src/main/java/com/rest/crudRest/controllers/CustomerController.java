package com.rest.crudRest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.crudRest.entities.Customer;
import com.rest.crudRest.repositories.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepo;

	@GetMapping("/getAllCustomers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		try {
			
			List<Customer> customerList = new ArrayList<>();
			customerRepo.findAll().forEach(customerList::add);
			
			if(customerList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(customerList, HttpStatus.OK);
			

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable UUID id) {
		try {
			
			Optional<Customer> customerData = customerRepo.findById(id);
			
			if(customerData.isPresent()) {
				Customer foundCustomer = customerData.get();
				return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer newCustomer) {
		try {
			
			Customer customerData = customerRepo.save(newCustomer);
			
			return new ResponseEntity<>(customerData, HttpStatus.CREATED);

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@PostMapping("/updateCustomerById/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable UUID id, @RequestBody Customer newCustomer) {
		try {
			
			Optional<Customer> customerData = customerRepo.findById(id);
			
			if(customerData.isPresent()) {
				Customer updatedCustomer = customerData.get();
				updatedCustomer.setName(newCustomer.getName());
				updatedCustomer.setEmail(newCustomer.getEmail());
				
				return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
	}

	@DeleteMapping("deleteCustomerById/{id}")
	public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable UUID id) {
		try {
			
			Optional<Customer> customerData = customerRepo.findById(id);
			
			if(customerData.isPresent()) {
				customerRepo.deleteById(id);
				
				return new ResponseEntity<>(HttpStatus.OK);
			}
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		} catch (Exception ex) {
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
	}

}
