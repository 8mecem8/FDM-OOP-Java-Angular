package service;

import util.EmailUtil;

import com.fdmgroup.subclasses.Account;
import com.fdmgroup.subclasses.Customer;

import jakarta.mail.MessagingException;



public class AlertService 
{
	//private List<Customer> AllcustomersList;
	
	 
	
	
	
    //public AlertService(List<Customer> customers){this.AllcustomersList = customers;}

	EmailUtil emailUtil = new EmailUtil();

	public void sendTransactionAlert(Customer customer, Account account, double transactionAmount) 
    {
        String message = generateAlertMessage(customer, account, transactionAmount);
        
        try{emailUtil.sendEmail(customer.getEmail(), "Transaction Alert", message);} catch (MessagingException e) {System.err.println("Failed to send email31: " + e.getMessage());}
    }
	
	public void sendBalanceViolationAlert(Customer customer, Account account) 
	{
        String message = generateBalanceViolationMessage(customer, account);
        
        try{emailUtil.sendEmail(customer.getEmail(), "Balance Violation Alert", message);} catch (MessagingException e) {System.err.println("Failed to send email: " + e.getMessage());}
    }
    
	
	public void sendDepositBoxAlert(Customer customer, String action) {
        String message = generateDepositBoxAlertMessage(customer, action);
        
        try {
        		emailUtil.sendEmail(customer.getEmail(), "Deposit Box Alert", message);
        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
	
	
	
    

    public String generateAlertMessage(Customer customer, Account account, double transactionAmount) 
    {
        return "Hello " + customer.getName() + "\n" +
               "We would like to notify you of a recent transaction on your account.\n" +
               "Transaction Details:\n" +
               "- Amount: $" + transactionAmount + "\n" +
               "- Account Number: " + account.getACCOUNT_ID() + "\n" +
               "- New Balance: $" + account.getBalance() + "\n" +
               "Thank you for banking with us.\n" +
               "Best regards,\n" +
               "Your Bank";
    }
    
    public String generateBalanceViolationMessage(Customer customer, Account account) {
        return "Hello " + customer.getName() + "\n" +
               "We would like to notify you that your account balance is below the minimum required balance.\n" +
               "Account Details:\n" +
               "- Account Number: " + account.getACCOUNT_ID() + "\n" +
               "- Current Balance: $" + account.getBalance() + "\n" +
               "Please ensure to maintain the minimum balance to avoid penalties.\n" +
               "Best regards,\n" +
               "Your Bank";
    }
    
    public String generateDepositBoxAlertMessage(Customer customer, String action) {
        return "Hello " + customer.getName() + "\n" +
               "We would like to notify you that your deposit box has been " + action + ".\n" +
               "Thank you for banking with us.\n" +
               "Best regards,\n" +
               "Your Bank";
    }
    
}  