package com.fdmgroup.subclasses;



public class CheckingAccount extends Account 
{
	private int nextCheckNumber = 1;

	
	
	
	public int getNextCheckNumber() {
		return nextCheckNumber++;
	}

	
}
