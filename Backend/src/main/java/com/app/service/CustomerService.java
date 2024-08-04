package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Customer;

public interface CustomerService {
 List<Customer> getAllCustomers();
 
 Optional<Customer> getCustomerById(Long id);
 
 Optional<Customer> getCustomerByEmail(String email);
 
 Customer addNewCustomer(Customer customer);
 
 Customer updateCustomer(Customer customer);
 
 String deleteCustomer(Long id);
 
}
