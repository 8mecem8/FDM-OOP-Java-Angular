package sprint3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.fdmgroup.controller.AccountController;
import com.fdmgroup.main.Index;
import com.fdmgroup.subclasses.Account;
import com.fdmgroup.subclasses.Customer;
import jakarta.mail.MessagingException;
import service.AlertService;
import service.SafetyDepositBox;
import service.SafetyDepositBoxService;
import util.EmailUtil;



@ExtendWith(MockitoExtension.class)
class MainTest {
	
	private static final Logger log = LogManager.getLogger(Index.class);
	
	Customer john;
	Account johnChecking;
	AccountController controller;

	@Mock
    private EmailUtil emailUtil;

    @InjectMocks
    private AlertService alertService;


    @BeforeEach
    public void setUp() 
    {

    	controller = new AccountController();

    }

    @Test
    void testSendTransactionAlert_success() throws MessagingException 
    {	
    		
    		Customer customer = mock(Customer.class);
    		Account account = controller.createAccount(customer, "checking");
    		var depositAmount = 1531.00;
    		
    		
    		when(customer.getName()).thenReturn("John Horger");
    		when(customer.getEmail()).thenReturn("cem.onal@fdmgroup.com");
    		//when(account.getBalance()).thenReturn(1000.0);
    	
    		account.deposit(depositAmount);
    		
    		if(account.getBalance() == depositAmount){alertService.sendTransactionAlert(customer, account, 500.00);}
    		
    		verify(emailUtil, times(1)).sendEmail(eq("cem.onal@fdmgroup.com"),eq("Transaction Alert"),anyString());
    		
        
    }
    
    @Test
    void testEmailisSaved() 
    {
//    		var emailToCheck = "cem.onal@fdmgroup.com";
//    		Customer customer = mock(Customer.class);
//    		AccountController controller = mock(AccountController.class);
//    		
//    		when(controller.createCustomer(anyString(), anyString(), anyString())).thenReturn(customer);
//    		Customer customera = controller.createCustomer(anyString(), anyString(), anyString());
//    		when(customera.getEmail()).thenReturn("cem.onal@fdmgroup.com");
//    		
//    		
//    		assertEquals(emailToCheck,customera.getEmail());  
    	
    			var emailToCheck = "cem.onal@fdmgroup.com";
    			
    			Customer customer = controller.createCustomer("John Horger", "123 Main St", "person");
    			customer.setEmail(emailToCheck);
    	
    	
    			assertEquals(emailToCheck,customer.getEmail());  
    }
    

    @Test
    void testSendBalanceViolationAlert_success() throws MessagingException 
    {
    		Customer customer = mock(Customer.class);
    		Account account = controller.createAccount(customer, "checking");
    		
    		when(customer.getName()).thenReturn("John Horger");
    		when(customer.getEmail()).thenReturn("cem.onal@fdmgroup.com");
    		account.correctBalance(500.00); // Set balance below minimum
     
    		
    		
    		var resultForWithdraw = account.withdraw(700.00);
    		
    		if(resultForWithdraw == -99.99)
    		{
    			alertService.sendBalanceViolationAlert(customer, account);
    			log.info("send balance violation email");
    		}
    		
    		verify(emailUtil, times(1)).sendEmail(eq("cem.onal@fdmgroup.com"),eq("Balance Violation Alert"),anyString());
        
    } 

    @Test
    void testSendDepositBoxAlert_success() throws MessagingException 
    {
    	
    		SafetyDepositBoxService service = SafetyDepositBoxService.getInstance();
    		Customer customer = mock(Customer.class);
    		
    		when(customer.getName()).thenReturn("John Horger");
    		when(customer.getEmail()).thenReturn("cem.onal@fdmgroup.com");
    		
    		SafetyDepositBox box = service.allocateSafetyDepositBox();
    		
    		if(box != null)
    		{
    			alertService.sendDepositBoxAlert(customer, "allocated");
    		}
    		
    		verify(emailUtil, times(1)).sendEmail(eq("cem.onal@fdmgroup.com"),eq("Deposit Box Alert"),argThat(arg -> arg.contains("allocated")));
    		
    		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}   		
    		
    		service.releaseSafetyDepositBox(box);
    		
    		var releasedBoxId = service.getReleasedSafetyDepositBox().get();
    		
    		if(releasedBoxId.equals(box.getId()))
    		{
    			alertService.sendDepositBoxAlert(customer, "released");
    			verify(emailUtil, times(1)).sendEmail(eq("cem.onal@fdmgroup.com"),eq("Deposit Box Alert"),argThat(arg -> arg.contains("released")));
    		}
    	    		
    }

}
