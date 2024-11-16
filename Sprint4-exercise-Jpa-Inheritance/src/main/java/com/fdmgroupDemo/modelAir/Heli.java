package com.fdmgroupDemo.modelAir;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Heli")
public class Heli extends VehicleAir 
{
	@Column(name = "Has_Carrier")
	private Boolean hasCarrier;

	public Boolean getHasCarrier() {return hasCarrier;}	public void setHasCarrier(Boolean hasCarrier) {this.hasCarrier = hasCarrier;}
	
}
