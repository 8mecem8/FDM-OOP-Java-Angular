package com.fdmgroupDemo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

@Entity
//@PrimaryKeyJoinColumn(name = "addressId")
public class Address 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank(message = "Street Number is required")
	@Column(name ="STREET_NUMBER", nullable = false)
	private String streetNumber;
	
    @Column(name ="CITY", nullable = false)
    @NotBlank(message = "City is required")
    private String city = "Default City";
	
	@NotBlank(message = "Province is required")
	@Column(name ="PROVINCE", nullable = false)
	private String province;
	
	@NotBlank(message = "Postal Code is required")
	@Column(name ="POSTAL_CODE", nullable = false)
	private String postalCode;

	// Address entity
	//@OneToOne(mappedBy = "address")
	//private Customer customer;
    
    
	
	
	
	
	public Address() {
		super();
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	
	
	//public Customer getCustomer() {return customer;}

	//public void setCustomer(Customer customer) {this.customer = customer;}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", streetNumber=" + streetNumber + ", city=" + city + ", province="
				+ province + ", postalCode=" + postalCode + ", getAddressId()=" + getAddressId()
				+ ", getStreetNumber()=" + getStreetNumber() + ", getPostalCode()=" + getPostalCode() + ", getCity()="
				+ getCity() + ", getProvince()=" + getProvince() + "]";
	}
	
	

   
}