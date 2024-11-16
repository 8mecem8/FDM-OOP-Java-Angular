package com.fdmgroup.subclasses;

import java.util.List;

public class PersonType extends Customer
{

	public PersonType(String name, String address) 
	{
		super(name, address);
		
	}
	
	
	@Override
	public void chargeAllAccounts(double amount) 
	{
		List<Account> userAccount = super.getAccounts();
		
		for (Account arg : userAccount) 
		{
			arg.withdraw(amount);
		}
	}


}
