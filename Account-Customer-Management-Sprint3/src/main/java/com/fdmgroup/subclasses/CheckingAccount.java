package com.fdmgroup.subclasses;

public class CheckingAccount extends Account 
{
	private int nextCheckNumber = 1;
	private static final double MINIMUM_BALANCE = 1000.00;
	
	
	
	public int getNextCheckNumber() {
		return nextCheckNumber++;
	}
	
	@Override
	public  double withdraw(double amount) {
	    super.withdraw(amount);
	    if (getBalance() < MINIMUM_BALANCE) {
	        return -99.99;
	    } else {
	    			 balance -= amount; return amount;
	    }
	} 


	
}
