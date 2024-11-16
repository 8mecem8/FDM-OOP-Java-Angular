package com.fdmgroupDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fdmgroupDemo.controller.CustomerController;
import com.fdmgroupDemo.model.Address;
import com.fdmgroupDemo.model.Company;
import com.fdmgroupDemo.model.CreateCustomer;
import com.fdmgroupDemo.model.Customer;
import com.fdmgroupDemo.model.Person;
import com.fdmgroupDemo.repository.Customer_Repository_Interface;
import com.fdmgroupDemo.service.CustomerService;


@SpringBootTest(classes = Sprint4Epic4Application.class) // Specify your main application class here
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class CustomerServiceTest 
{

    @MockBean
    Customer_Repository_Interface customerRepo;
    
    @MockBean
    CustomerService customerService;
    
    @InjectMocks
    private CustomerService realCustomerService; // Real instance with injected mocks
    
    @InjectMocks
    private CustomerController customerController;
    
    
    
    @Test
    void createPersonTest() 
    {
   		//Declare
        CreateCustomer newPersonCustomerForTest = new CreateCustomer("testName", "st number", "M4R 0A1", "person");
    		// Mock
        Mockito.when(customerService.createNewCustomer(Mockito.any(CreateCustomer.class))).thenReturn(new Person());

    		// Act
        Customer customer = customerService.createNewCustomer(newPersonCustomerForTest);
        customerRepo.save(customer);
        
        // Assert
        assertNotNull(customer);
        // Verify 
        Mockito.verify(customerRepo).save(Mockito.any(Person.class));
    }
    
    @Test
    void createCompanyTest() 
    {
    		//Declare
	    	CreateCustomer newCompanyCustomerForTest = new CreateCustomer("testName", "st number", "M4R 0A1", "company");
	    	// Mock
	    	Mockito.when(customerService.createNewCustomer(Mockito.any(CreateCustomer.class))).thenReturn(new Company());
	    	
	    	// Act
	    	Customer customer = customerService.createNewCustomer(newCompanyCustomerForTest);
	    	customerRepo.save(customer);
	    	
	    	// Assert
	    	assertNotNull(customer);
	    	// Verify 
	    	Mockito.verify(customerRepo).save(Mockito.any(Company.class));
    }
    
    @Test
    void getAllCustomersTest() 
    {
    			//Mockito.when(customerService.getAllCustomersList()).thenReturn(Arrays.asList(Mockito.any(Company.class)));
    	
    		// Arrange
    	    List<Customer> expectedCustomers = Arrays.asList(
            Person.builder().name("TestName1").build(),
            Person.builder().name("TestName2").build(),
            Person.builder().name("TestName3").build());
    		// Mock
        Mockito.when(customerService.getAllCustomersList()).thenReturn(expectedCustomers);

        // Act
        List<Customer> actualCustomers = customerController.getAllCustomers();

        // Assert
        assertNotNull(actualCustomers);
        assertEquals(expectedCustomers.size(), actualCustomers.size());
        assertEquals(expectedCustomers, actualCustomers);
    }
    
    @Test
    void getCustomerByIdTest() 
    {
    		// Arrange
    		long id = 3L;Customer customertoTest = new Person(); customertoTest.setName("testCustomerName"); customertoTest.setCustomerId(id); customertoTest.setAddress(new Address());
    		// Mock
    		Mockito.when(customerRepo.findById(id)).thenReturn(Optional.of(customertoTest));
    		// Act
    		Customer result = realCustomerService.findCustomerById(id);
    		// Assert
        assertEquals(customertoTest, result);
    }
    
    @Test
    void updateCustomerByIdTest() 
    {
    		// Arrange
		long id = 6L;Customer customertoTest = new Person(); customertoTest.setName("testCustomerName"); customertoTest.setCustomerId(id);
    	
    		Mockito.when(customerRepo.findById(1L)).thenReturn(Optional.of(customertoTest)); 
    		Mockito.when(customerRepo.save(Mockito.any(Customer.class))).thenReturn(customertoTest);

        Customer updatedCustomer = new Customer() {};
        updatedCustomer.setName("Updated Customer");

        Customer result = realCustomerService.updateCustomer(1L, updatedCustomer);

        assertEquals("Updated Customer", result.getName());
    }
    
    
    @Test
    void deleteCustomerByIdTest() 
    {
    	
    		long id = 8L;Customer customertoTest = new Person(); customertoTest.setName("testCustomerName"); customertoTest.setCustomerId(id);
    		Mockito.when(customerRepo.findById(1L)).thenReturn(Optional.of(customertoTest));

    		realCustomerService.deleteCustomer(1L);

        Mockito.verify(customerRepo).delete(customertoTest);
    }
    
    
}
