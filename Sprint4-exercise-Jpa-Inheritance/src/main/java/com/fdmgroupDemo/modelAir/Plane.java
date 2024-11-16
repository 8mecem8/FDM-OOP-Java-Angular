package com.fdmgroupDemo.modelAir;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Plane")
public class Plane extends VehicleAir 
{
	@Column(name = "Number_of_Doors")
	private Integer numberOfDoors;

	
	
	
	public Integer getNumberOfDoors() {return numberOfDoors;} 	public void setNumberOfDoors(Integer numberOfDoors) {this.numberOfDoors = numberOfDoors;}
	
}
