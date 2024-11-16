package com.fdmgroupDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import com.fdmgroupDemo.Uti.Model.CustomerUpt;
import com.fdmgroupDemo.exception.ResourceNotFoundException;
import com.fdmgroupDemo.model.Address;
import com.fdmgroupDemo.model.Company;
import com.fdmgroupDemo.model.CreateCustomer;
import com.fdmgroupDemo.model.Customer;
import com.fdmgroupDemo.model.Person;
import com.fdmgroupDemo.repository.Customer_Repository_Interface;

import java.util.List;
import java.util.Optional;


@Service 
public class CustomerService 
{ 
	Customer_Repository_Interface customerRepo;
	GeocodingService geocoderService;

	@Autowired
	public CustomerService(Customer_Repository_Interface customerRepo,GeocodingService geocoderService)	{super();this.customerRepo = customerRepo;this.geocoderService = geocoderService;}
	
	
	public Customer createNewCustomer(CreateCustomer newCustomer)
	{
		JsonNode jdata = geocoderService.getCityAndProvince(newCustomer.getPostalCode());
		
		//JsonNode province = jdata.get("standard").get("prov");
		//JsonNode city = jdata.get("standard").get("city");
		
		JsonNode province = Optional.ofNullable(jdata.get("standard")).map(node -> node.get("prov")).orElse(null);
        JsonNode city = Optional.ofNullable(jdata.get("standard")).map(node -> node.get("city")).orElse(null);

		
//		Customer customer = new Customer(); 
//		Address address = new Address(); 
//		
//        customer.setName(newCustomer.getName()); 
//        address.setStreetNumber(newCustomer.getStreetNumber());
//        address.setPostalCode(newCustomer.getPostalCode()); 
//        address.setCity(city.asText()); 
//        address.setProvince(province.asText());
//        customer.setAddress(address);
        
        
        Address address = new Address();
        address.setStreetNumber(newCustomer.getStreetNumber()); address.setPostalCode(newCustomer.getPostalCode()); 
        address.setCity(city.asText());  address.setProvince(province.asText());
        
        Customer customer;
        if (newCustomer.getCustomerType().equalsIgnoreCase("PERSON")) {customer = new Person();} else if (newCustomer.getCustomerType().equalsIgnoreCase("COMPANY")) {customer = new Company();} else {throw new IllegalArgumentException("Invalid customer type");}
        
        customer.setName(newCustomer.getName()); customer.setAddress(address);
        	
        return customerRepo.save(customer);
	
	}
	 
	public Customer findCustomerById(Long userId){return customerRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + userId));}
	
	
	public Customer updateCustomer(Long id, CustomerUpt customerDetails) 
	{
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
        Address address = new Address();
        
        address.setCity(customerDetails.getCity()); address.setPostalCode(customerDetails.getPostalCode());
        address.setProvince(customerDetails.getProvince()); address.setStreetNumber(customerDetails.getStreetNumber());
        
        customer.setAddress(address);
        customer.setName(customerDetails.getName());
        
        return customerRepo.save(customer);
    } 
	
	public void deleteCustomer(Long id) 
	{
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id)); customerRepo.delete(customer);
    }
	
	public List<Customer> getAllCustomersList(){return customerRepo.findAll();	}
}
