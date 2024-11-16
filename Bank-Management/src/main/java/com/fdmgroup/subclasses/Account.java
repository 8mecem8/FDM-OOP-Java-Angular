package com.fdmgroup.subclasses;

public abstract class Account 
{
	private final long ACCOUNT_ID;
	static private long nextAccountId = 1_000;
	protected double balance;
	
	public Account() 
	{
		this.ACCOUNT_ID = nextAccountId;
		nextAccountId = this.ACCOUNT_ID + 5;

	}
	
	
	
	public double withdraw(double amount)
	{
		balance -= amount;	
		return amount;
		
	}
	public void deposit(double amount) 
	{
		balance += amount;
	}
	public void correctBalance(double amount) 
	{
		balance = amount;
	}


	
	

	public long getACCOUNT_ID() {
		return ACCOUNT_ID;
	}


	public double getBalance() {
		return balance;
	}
	
		
}
