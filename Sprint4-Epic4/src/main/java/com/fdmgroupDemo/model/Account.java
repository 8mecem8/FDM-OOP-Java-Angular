package com.fdmgroupDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
@Inheritance(strategy = InheritanceType.JOINED)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,  property = "accountId")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACCOUNT_ID")
	private Integer accountId;
	
	@Column(name = "BALANCE", nullable = false)
	private double balance;
	
	//@JsonManagedReference
	@ManyToOne
    @JoinColumn(name = "FK_CUST_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
	//@JsonSerialize(using = CustomCustomerSerializer.class)
    private Customer customer;
	
	
	
	public Account() {super();}

	
	public long getAccountId() {return accountId;	}
	public double getBalance() {return balance;}
	public void setBalance(double balance) {this.balance = balance;}
	public Customer getCustomer() {return customer;}
	public void setCustomer(Customer customer) {this.customer = customer;}
	
	
	

}
