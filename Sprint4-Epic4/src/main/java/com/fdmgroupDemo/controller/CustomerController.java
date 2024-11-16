package com.fdmgroupDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroupDemo.Uti.Model.CustomerUpt;
import com.fdmgroupDemo.exception.ResourceNotFoundException;
import com.fdmgroupDemo.model.CreateCustomer;
import com.fdmgroupDemo.model.Customer;
import com.fdmgroupDemo.service.CustomerService;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1/customer")
@Tag(name = "Customer Management", description = "Operations pertaining to customers in the bank")
public class CustomerController 
{
	CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {super();this.customerService = customerService;}


	
	@GetMapping
	@Operation(summary = "Get all customers")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of customers")
    public List<Customer> getAllCustomers() {return customerService.getAllCustomersList();}
	
	
	
	@GetMapping("/{id}")
	@Operation(summary = "Get a customer by ID")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully retrieved the customer"), @ApiResponse(responseCode = "404", description = "Customer not found")})
	public ResponseEntity<Customer> getSpecCustomer(@PathVariable Long id) 
	{
		try {Customer customer = customerService.findCustomerById(id); return ResponseEntity.ok(customer);} 
		catch (ResourceNotFoundException e) {return ResponseEntity.notFound().build();}
	}
	
	@PostMapping
	@Operation(summary = "Create a new customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully created the customer"),@ApiResponse(responseCode = "400", description = "Invalid input")})
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CreateCustomer customer) 
	{
        return ResponseEntity.ok(customerService.createNewCustomer(customer));
    }
	
	
	
	@PutMapping("/{id}")
	@Operation(summary = "Update a customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully updated the customer"), @ApiResponse(responseCode = "400", description = "Invalid input"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerUpt customerDetails)  
	{	
		
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a customer")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Successfully deleted the customer"), @ApiResponse(responseCode = "404", description = "Customer not found")})
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) 
    {
        customerService.deleteCustomer(id);
        return ResponseEntity.ok().build();
    }
	
}
