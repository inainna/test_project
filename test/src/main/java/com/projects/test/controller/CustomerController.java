package com.projects.test.controller;

import com.projects.test.exception.CustomerNotFoundException;
import com.projects.test.model.Customer;
import com.projects.test.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

@Autowired
    CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getAllTransactions() {
        return customerRepository.findAll();
    }

    @PostMapping("/customers")
    public Customer createTransaction(@Valid @RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") Long customerID) throws CustomerNotFoundException {
        return customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));
    }

    @PutMapping("/customers/{id}")
    public Customer updateCustomers(@PathVariable(value = "id") Long customerID,
                           @Valid @RequestBody Customer customerDetails) throws CustomerNotFoundException {

Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));

customer.setFirstName(customerDetails.getFirstName());
customer.setLastName(customerDetails.getLastName());


Customer updatedCustomer = customerRepository.save(customer);

return updatedCustomer;
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable(value = "id") Long customerID) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));

customerRepository.delete(customer);

return ResponseEntity.ok().build();
    }
}
