package com.fdmgroupDemo.model;

import org.springframework.stereotype.Component;

@Component
public class AccountDTO 
{
	
	//@JsonProperty("customerId")
	private Integer customerId;
	private double balance;
	private String type;
	private double interestRate;
	 
	 
	 
	 
	
	public Integer getCustomerId() {return customerId;}
	public void setCustomerId(Integer customerId) {this.customerId = customerId;	}
	public double getBalance() {return balance;}
	public void setBalance(double balance) {this.balance = balance;}
	public double getInterestRate() {	return interestRate;}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
	}





	@Override
	public String toString() {
		return "AccountDTO [customerId=" + customerId + ", balance=" + balance + ", type=" + type + ", interestRate="
				+ interestRate + "]";
	}





	 

}
