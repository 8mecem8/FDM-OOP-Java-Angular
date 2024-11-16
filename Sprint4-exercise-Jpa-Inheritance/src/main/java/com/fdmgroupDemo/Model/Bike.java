package com.fdmgroupDemo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Bike")
public class Bike extends Vehicle 
{
	@Column(name = "Has_Carrier")
	private Boolean hasCarrier;

	public Boolean getHasCarrier() {return hasCarrier;}	public void setHasCarrier(Boolean hasCarrier) {this.hasCarrier = hasCarrier;}
	
}
