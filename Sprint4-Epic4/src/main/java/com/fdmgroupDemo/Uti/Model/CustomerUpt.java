package com.fdmgroupDemo.Uti.Model;

import org.springframework.stereotype.Component;

@Component
public class CustomerUpt 
{
	private String type;
	private String name; 
	private String province;
	private String city;
	private String streetNumber;
	private String postalCode;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	@Override
	public String toString() {
		return "CustomerUpt [type=" + type + ", name=" + name + ", province=" + province + ", city=" + city
				+ ", streetNumber=" + streetNumber + ", postalCode=" + postalCode + ", getType()=" + getType()
				+ ", getName()=" + getName() + ", getProvince()=" + getProvince() + ", getCity()=" + getCity()
				+ ", getStreetNumber()=" + getStreetNumber() + ", getPostalCode()=" + getPostalCode() + "]";
	}
	
	
	
	
	
	

}
