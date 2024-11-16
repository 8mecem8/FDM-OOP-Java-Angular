package com.fdmgroupDemo.model;

import jakarta.validation.constraints.NotBlank;

public class CreateCustomer //customerDTO
{
	@NotBlank(message = "Name is required")
	private String name;
	
	@NotBlank(message = "Street Number is required")
	private String streetNumber;
	
	@NotBlank(message = "Postal Code is required")
	private String postalCode;
	
	@NotBlank(message = "Customer Type is required")
	private String customerType;
	
	
	
	public CreateCustomer() {super();	}
	public CreateCustomer(@NotBlank(message = "Name is required") String name,	@NotBlank(message = "Street Number is required") String streetNumber,	@NotBlank(message = "Postal Code is required") String postalCode,	@NotBlank(message = "Customer Type is required") String customerType) 
	{super();this.name = name;this.streetNumber = streetNumber;this.postalCode = postalCode;this.customerType = customerType;}

	public String getName() {return name;	}
	public void setName(String name) {this.name = name;}
	public String getStreetNumber() {	return streetNumber;}
	public void setStreetNumber(String streetNumber) {this.streetNumber = streetNumber;}
	public String getPostalCode() {return postalCode;	}
	public void setPostalCode(String postalCode) {this.postalCode = postalCode;}
	public String getCustomerType() {	return customerType;	}
	public void setCustomerType(String customerType) {this.customerType = customerType;}


}
