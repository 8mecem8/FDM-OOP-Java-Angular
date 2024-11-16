//package main;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import com.fdmgroup.controller.AccountController;
//import com.fdmgroup.main.Index;
//import com.fdmgroup.subclasses.Account;
//import com.fdmgroup.subclasses.Customer;
//
//import service.AlertService;
//
//public class index {
//
//	private static final Logger log = LogManager.getLogger(Index.class);
//	
//	public static void main(String[] args) 
//	{
//		
//		
//		AccountController controller = new AccountController();
//		
//		List<Customer> customersList = new ArrayList<>();
//		//var accountsList = new ArrayList<>();
//		
//		// Create a new customer
//		Customer john = controller.createCustomer("John Horger", "123 Main St", "person");
//		john.setEmail("cem.onal@fdmgroup.com");
//		
//		// Create accounts for the customer
//        Account johnChecking = controller.createAccount(john, "checking");
//        // Deposit and Withdraw from accounts
//        johnChecking.deposit(1531);
//		
//        
//        
//        customersList.add(john);
//       
//        
//        log.info(john.getAccounts());
//        
//        AlertService alertService = new AlertService();
//        alertService.sendTransactionAlert(john, johnChecking, 500.00);
//
//	}
//
//}
