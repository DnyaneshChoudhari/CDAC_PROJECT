package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Customer;
import com.app.service.CustomerService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<?> listAllCustomers(){
		try {
			List<Customer> allCustomers = customerService.getAllCustomers();
			return ResponseEntity.status(HttpStatus.OK).body(allCustomers);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
	@GetMapping("/{customerId}")
	public ResponseEntity<?> customerById(@PathVariable Long id){
		try {
			Customer customerById = customerService.getCustomerById(id);
			return ResponseEntity.status(HttpStatus.OK).body(customerById);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> customerByEmail(@PathVariable String email){
		try {
			Customer customerByEmail = customerService.getCustomerByEmail(email);
			return ResponseEntity.status(HttpStatus.OK).body(customerByEmail);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
	@PostMapping
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
		try {
			Customer newCustomer = customerService.addNewCustomer(customer);
			return ResponseEntity.status(HttpStatus.OK).body(newCustomer);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
	@PutMapping
	public ResponseEntity<?> editCustomer(@RequestBody Customer customer){
		try {
			Customer updateCustomer = customerService.updateCustomer(customer);
			return ResponseEntity.status(HttpStatus.OK).body(updateCustomer);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<?> removeCustomer(@PathVariable Long id){
		try {
			String deleteCustomer = customerService.deleteCustomer(id);
			return ResponseEntity.status(HttpStatus.OK).body(deleteCustomer);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
}
