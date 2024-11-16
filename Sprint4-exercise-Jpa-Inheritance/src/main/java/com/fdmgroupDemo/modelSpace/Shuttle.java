package com.fdmgroupDemo.modelSpace;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Shuttle extends VehicleSpace 
{
	@Column(name = "Has_Carrier")
	private Boolean hasCarrier;

	public Boolean getHasCarrier() {return hasCarrier;}	public void setHasCarrier(Boolean hasCarrier) {this.hasCarrier = hasCarrier;}
	
}
