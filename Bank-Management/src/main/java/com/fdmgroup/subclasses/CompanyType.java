package com.fdmgroup.subclasses;

import java.util.List;

public class CompanyType extends Customer
{

	public CompanyType(String name, String address) 
	{
		super(name, address);
		
	}

	
	
	@Override
    public void chargeAllAccounts(double amount) 
	{
		List<Account> userAccount = super.getAccounts();
		
        for (Account arg : userAccount) 
        {
            if (arg instanceof CheckingAccount) 
            {
                arg.withdraw(amount);
            }
            
            if (arg instanceof SavingsAccount) 
            {
                arg.withdraw(amount * 2);
            }
        }
    }
}
