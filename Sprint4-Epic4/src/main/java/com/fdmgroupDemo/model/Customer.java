package com.fdmgroupDemo.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "CUSTOMER_TYPE")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = Person.class, name = "person"), @JsonSubTypes.Type(value = Company.class, name = "company")})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "customerId")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence", allocationSize = 1)
	@Column(name = "CUSTOMER_ID")
	private long customerId;
	
	@NotBlank(message = "Name is required")
    @Column(name = "CUSTOMER_NAME", nullable = false)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_ADDRESS_ID", referencedColumnName = "addressId")
	private Address address;

	//@JsonManagedReference
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Account> accounts;
	
	
	

	public Customer() {super();}
	

	
	public long getCustomerId() {return customerId;}
	public void setCustomerId(long customerId) {this.customerId = customerId;}
	public String getName() {return name;	}
	public void setName(String name) {this.name = name;}
	public Address getAddress() {return address;}
	public void setAddress(Address address) {	this.address = address;}
	

	public List<Account> getAccounts() {
		return accounts;
	}



	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}



	public void addAccount(Account account) { this.accounts.add(account);}
	public void deleteAccount(Account account) { this.accounts.remove(account);}



	@Override
	public String toString() {return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + ", accounts="+ accounts.toString() + "]";} 


	
}
