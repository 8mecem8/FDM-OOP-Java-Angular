package com.fdmgroupDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroupDemo.exception.ResourceNotFoundException;
import com.fdmgroupDemo.model.Account;
import com.fdmgroupDemo.model.AccountDTO;
import com.fdmgroupDemo.model.CheckingAccount;
import com.fdmgroupDemo.model.Customer;
import com.fdmgroupDemo.model.SavingsAccount;
import com.fdmgroupDemo.repository.AccountRepository;
import com.fdmgroupDemo.repository.Customer_Repository_Interface;

import java.util.List;

@Service
public class AccountService 
{
	AccountRepository accountRepo;
	Customer_Repository_Interface customerRepo;
	
	
	
	@Autowired
	public AccountService(AccountRepository accountRepo, Customer_Repository_Interface customerRepo) {
		super();
		this.accountRepo = accountRepo;
		this.customerRepo = customerRepo;
	} 

	
	public List<Account> getAllAccountsList()
	{
		return accountRepo.findAll();
	}
	
	
	public Account createAccount(AccountDTO accountRequest) 
	{
	    
	    Customer customer = customerRepo.findById((long) accountRequest.getCustomerId()).get();

	    Account newAccount = null;
	    if ("checkings".equals(accountRequest.getType())) {newAccount = new CheckingAccount();} 
	    else if ("savings".equals(accountRequest.getType())) {newAccount = new SavingsAccount();   ((SavingsAccount) newAccount).setInterestRate(accountRequest.getInterestRate());}
	    if (newAccount != null) {
	        newAccount.setBalance(accountRequest.getBalance());
	        newAccount.setCustomer(customer);
	        customer.addAccount(newAccount);
	        System.out.println(customer);
	    }
	    
	    
	    return accountRepo.save(newAccount);
	}
	
	 public List<Account> getAccountsByCustomerCity(String city) {return accountRepo.findAllByCustomerCity(city);}
	 
	 public void deleteAccount(Integer id) 
		{
	        Account account = accountRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));

	        accountRepo.delete(account);
	    }
}
