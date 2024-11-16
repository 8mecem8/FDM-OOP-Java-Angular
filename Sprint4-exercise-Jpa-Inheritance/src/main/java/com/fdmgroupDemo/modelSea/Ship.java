package com.fdmgroupDemo.modelSea;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Ship")
public class Ship extends VehicleSea 
{
	@Column(name = "Has_Carrier")
	private Boolean hasCarrier;

	public Boolean getHasCarrier() {return hasCarrier;}	public void setHasCarrier(Boolean hasCarrier) {this.hasCarrier = hasCarrier;}
	
}
