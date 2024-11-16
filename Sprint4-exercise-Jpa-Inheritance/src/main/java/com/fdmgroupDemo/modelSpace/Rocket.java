package com.fdmgroupDemo.modelSpace;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Rocket extends VehicleSpace 
{
	@Column(name = "Number_of_Doors")
	private Integer numberOfDoors;

	
	
	
	public Integer getNumberOfDoors() {return numberOfDoors;} 	public void setNumberOfDoors(Integer numberOfDoors) {this.numberOfDoors = numberOfDoors;}
	
}
