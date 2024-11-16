package com.fdmgroupDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.fdmgroupDemo.model.AccountDTO;
import com.fdmgroupDemo.model.Customer;
import com.fdmgroupDemo.repository.AccountRepository;
import com.fdmgroupDemo.repository.Customer_Repository_Interface;
import com.fdmgroupDemo.service.AccountService;

@SpringBootTest(classes = Sprint4Epic4Application.class) // Specify your main application class here
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
class AccountServiceTest 
{
	@Mock
    private AccountRepository accountRepo;

    @Mock
    private Customer_Repository_Interface customerRepo;

    @InjectMocks
    private AccountService accountService;
	
    private Customer testCustomer;
    private AccountDTO testAccountDTO;
    
    @BeforeEach
    void setUp() {
        testCustomer = new Customer() {};
        testCustomer.setName("Test Customer");

        testAccountDTO = new AccountDTO();
        testAccountDTO.setCustomerId(1);
        testAccountDTO.setType("savings");
        testAccountDTO.setBalance(100.00);
        testAccountDTO.setInterestRate(0.05);
    }
    
    @Test
    void createAccountTest() 
    {
    		//Customer customer = customerRepo.findById(1l).thenReturn(Optional.of(Mockito.any(Customer.class)));
    	 	//Mockito.when(customerRepo.findById(1L)).thenReturn(Optional.of(testCustomer));
    	 	//Mockito.when(accountRepo.save(Mockito.any(Account.class))).thenAnswer(i -> i.getArguments()[0]);

         //Account createdAccount = accountService.createAccount(testAccountDTO);
         
         //System.out.println(createdAccount);
         //System.out.println("zurna");
         
         
         
         //assertEquals(testAccountDTO.getBalance(), createdAccount.getBalance());
         //assertEquals(testCustomer, createdAccount.getCustomer());
    }
}
