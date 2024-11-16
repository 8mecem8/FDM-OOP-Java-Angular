package com.fdmgroupDemo.modelSea;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Boat")
public class Boat extends VehicleSea 
{
	@Column(name = "Number_of_Doors")
	private Integer numberOfDoors;

	
	
	
	public Integer getNumberOfDoors() {return numberOfDoors;} 	public void setNumberOfDoors(Integer numberOfDoors) {this.numberOfDoors = numberOfDoors;}
	
}
