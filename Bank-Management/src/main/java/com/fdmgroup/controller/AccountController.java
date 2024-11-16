package com.fdmgroup.controller;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.subclasses.Account;
import com.fdmgroup.subclasses.CheckingAccount;
import com.fdmgroup.subclasses.Customer;
import com.fdmgroup.subclasses.PersonType;
import com.fdmgroup.subclasses.SavingsAccount;
import com.fdmgroup.subclasses.CompanyType;




public class AccountController 
{
	private List<Customer> customers = new ArrayList<>();
	private List<Account> Accounts = new ArrayList<>();
	
	

	
	
	public Customer createCustomer(String name, String address, String type) 
	{
		Customer customer = null;
		
        if (type.equalsIgnoreCase("person")) 
        {
            customer = new PersonType(name, address);
        }
        if (type.equalsIgnoreCase("company")) 
        {
            customer = new CompanyType(name, address);
        }
        
        
	        if (customer != null) 
	        {
	            this.customers.add(customer);
	        }
        
	        return customer;
	}
	
	public Account createAccount(Customer customer, String type) 
	{
		Account account = null;
		
		if(type.equalsIgnoreCase("checking")) 
		{
			account = new CheckingAccount() ;
		}
		if(type.equalsIgnoreCase("savings")) 
		{
			account = new SavingsAccount() ;
		}
		
		
		
			if(account != null) 
			{
				this.Accounts.add(account);
				customer.addAccount(account);
			}
		
			
			return account; 
	}
	
	
	public void removeCustomer(Customer customer) 
	{
		customers.remove(customer);
		Accounts.removeAll(customer.getAccounts());
	}
	
	public void removeAccount(Account account) 
	{
		Accounts.remove(account);
		for (Customer arg : customers) {
            arg.removeAccount(account);
        }
	}
	
	
	public List<Customer> getCustomers() 
	{
		return customers;
	}
	public List<Account> getAccounts() 
	{
		return Accounts;
	}
	
	
	
	
	public void setCustomers(List<Customer> customers) 
	{
		this.customers = customers;
	}
	public void setAccounts(List<Account> accounts) 
	{
		Accounts = accounts;
	}

	
}
