package com.fdmgroupDemo;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fdmgroupDemo.controller.CustomerController;
import com.fdmgroupDemo.model.CreateCustomer;
import com.fdmgroupDemo.model.Customer;
import com.fdmgroupDemo.model.Person;
import com.fdmgroupDemo.service.CustomerService;


@WebMvcTest(CustomerController.class)
class CustomerControllerUnitTests 
{

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService mockCustomerService;
    
    private Customer testCustomer;
    @BeforeEach
    void setUp() {
        testCustomer = new Customer() {};
        testCustomer.setName("Test Customer");
    }

    @Test
    void getCustomerById() throws Exception { 
        Customer mockCustomer = new Person();
        mockCustomer.setName("Paul");

        when(mockCustomerService.findCustomerById(1L)).thenReturn(mockCustomer);

        mockMvc.perform(get("/api/v1/customer/{customerId}", 1L)).andExpect(status().isOk()).andExpect(jsonPath("$.name").value("Paul"));
    }
    
//    @Test
//    void getCustomerByIdNotFound() throws Exception {
//        when(mockCustomerService.findCustomerById(anyLong())).thenThrow(new EntityNotFoundException("Customer not found"));
//
//        mockMvc.perform(get("/api/v1/customer/{customerId}", 10L)).andExpect(status().isNotFound());
//    }

    @Test
    void getAllCustomers() throws Exception {
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(Person.builder().name("Paul").build());

        when(mockCustomerService.getAllCustomersList()).thenReturn(mockCustomers);

        mockMvc.perform(get("/api/v1/customer")).andExpect(status().isOk()).andExpect(jsonPath("$[0].name").value("Paul"));

    }
    
    @Test
    void createCustomer() throws Exception {
        when(mockCustomerService.createNewCustomer(Mockito.any(CreateCustomer.class))).thenReturn(testCustomer);

        mockMvc.perform(post("/api/v1/customer")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"Test Customer\",\"streetNumber\":\"123\",\"postalCode\":\"12345\",\"customerType\":\"PERSON\"}"))
                .andExpect(status().isOk());
    }
    
    @Test
    void updateCustomer() throws Exception 
    {
    
        when(mockCustomerService.updateCustomer(Mockito.eq(1L), Mockito.any(Customer.class))).thenReturn(testCustomer);

        mockMvc.perform(put("/api/v1/customer/1")
                .contentType(MediaType.APPLICATION_JSON)
                //.content("{\"name\":\"testname\",\"address\":{\"addressId\":2,\"streetNumber\":\"st number\",\"city\":\"Toronto\",\"province\":\"ON\",\"postalCode\":\"M4R 0A1\"}}"))
                .content("{\"type\":\"person\",\"name\":\"Updated Customer\"}"))
                .andExpect(status().isOk());
    }
    
    @Test
    void deleteCustomer() throws Exception {
        doNothing().when(mockCustomerService).deleteCustomer(1L);

        mockMvc.perform(delete("/api/v1/customer/1"))
                .andExpect(status().isOk());
    }
}
