package com.fdmgroup.subclasses;

import java.util.ArrayList;
import java.util.List;

public abstract  class Customer 
{
	private final long CUSTOMER_ID;
	static private long nextCustomerId = 2_000_000;
	private String name;
	private String address;
	private String email;
	private List<Account> accounts = new ArrayList<>();
	
	
	public Customer(String name, String address) 
	{
		this.CUSTOMER_ID = nextCustomerId;
		nextCustomerId = this.CUSTOMER_ID + 7;
		this.name = name;
		this.address = address;
	}
	
	
	public void addAccount(Account account) 
	{
		accounts.add(account);
	}
	public void removeAccount(Account account) 
	{
		accounts.remove(account);
	}
	public abstract void chargeAllAccounts(double amount);
	


	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}


	public List<Account> getAccounts() {
		return accounts;
	}
	
	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


	@Override
	public String toString() {
		return "Customer [CUSTOMER_ID=" + CUSTOMER_ID + ", name=" + name + ", address=" + address + ", email=" + email
				+ ", accounts=" + accounts + ", getName()=" + getName() + ", getAddress()=" + getAddress()
				+ ", getCUSTOMER_ID()=" + getCUSTOMER_ID() + ", getAccounts()=" + getAccounts() + ", getEmail()="
				+ getEmail() + "]";
	}
    
    
    
	
}
