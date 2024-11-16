package com.fdmgroup.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fdmgroup.controller.AccountController;
import com.fdmgroup.subclasses.Account;
import com.fdmgroup.subclasses.Customer;




public class Index 
{
	
	public static void main(String[] args) 
	{
		
//		ArrayList<String> listArray = new ArrayList<>();
//		
//		listArray.add("John");
//		listArray.add("Morn");
//		listArray.add("Mike");
//		
//		
//		
//		System.out.println(listArray.get(listArray.size()-1));
		
		
		AccountController controller = new AccountController();

        // Create a new customer
        Customer john = controller.createCustomer("John Horger", "123 Main St", "person");
        Customer Mike = controller.createCustomer("Mike Kotue", "456 soho Ave", "company");

        // Create accounts for the customer
        Account johnChecking = controller.createAccount(john, "checking");
        Account johnSavings = controller.createAccount(john, "savings");

        Account mikeChecking = controller.createAccount(Mike, "checking");
        Account mikeSavings = controller.createAccount(Mike, "savings");

        // Deposit and Withdraw from accounts
        johnChecking.deposit(1000);
        johnSavings.deposit(5000);
        mikeChecking.deposit(2000);
        mikeSavings.deposit(10000);

        System.out.println(johnChecking.getBalance());
        System.out.println(johnSavings.getBalance());
        System.out.println(mikeChecking.getBalance());
        System.out.println(mikeSavings.getBalance());
        
        johnChecking.withdraw(200);
        johnSavings.withdraw(1000);
        mikeChecking.withdraw(500);
        mikeSavings.withdraw(2000);
        
        
        System.out.println(johnChecking.getBalance());
        System.out.println(johnSavings.getBalance());
        System.out.println(mikeChecking.getBalance());
        System.out.println(mikeSavings.getBalance());

        // Correct balance
        johnChecking.correctBalance(800);
        johnSavings.correctBalance(4000);
        mikeChecking.correctBalance(1500);
        mikeSavings.correctBalance(8000);
        
        
        System.out.println(johnChecking.getBalance());
        System.out.println(johnSavings.getBalance());
        System.out.println(mikeChecking.getBalance());
        System.out.println(mikeSavings.getBalance());

        // Charge fees
        john.chargeAllAccounts(50);
        Mike.chargeAllAccounts(100);
        
        System.out.println(johnChecking.getBalance());
        System.out.println(johnSavings.getBalance());
        System.out.println(mikeChecking.getBalance());
        System.out.println(mikeSavings.getBalance());

        // Remove account and customer
        
        System.out.println("Remaining customers: " + controller.getCustomers().size());
        System.out.println("Remaining accounts: " + controller.getAccounts().size());
        
        
        controller.removeAccount(johnChecking);
        controller.removeCustomer(Mike);
        
     
        System.out.println("Remaining customers: " + controller.getCustomers().size());
        System.out.println("Remaining accounts: " + controller.getAccounts().size());

	}

}
