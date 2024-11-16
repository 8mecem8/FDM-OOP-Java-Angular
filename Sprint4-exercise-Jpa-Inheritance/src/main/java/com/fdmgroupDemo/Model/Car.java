package com.fdmgroupDemo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Car")
public class Car extends Vehicle 
{
	@Column(name = "Number_of_Doors")
	private Integer numberOfDoors;

	
	
	
	public Integer getNumberOfDoors() {return numberOfDoors;} 	public void setNumberOfDoors(Integer numberOfDoors) {this.numberOfDoors = numberOfDoors;}
	
}
