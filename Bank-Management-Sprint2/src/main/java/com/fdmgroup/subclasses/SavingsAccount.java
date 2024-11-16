package com.fdmgroup.subclasses;



public class SavingsAccount extends Account 
{
	private double interestRate;
	
	
	
	
	
	
	public void addInterest() 
	{
		super.balance += (super.balance*(this.interestRate / 100));
	}


	public double getInterestRate() {
		return interestRate;
	}


	public void setInterestRate(double rate) {
		this.interestRate = rate;
	}
	
	@Override
    public double withdraw(double amount) 
	{
        if (amount > super.getBalance()){return 0;}
        return super.withdraw(amount);
    }
	
	
}
