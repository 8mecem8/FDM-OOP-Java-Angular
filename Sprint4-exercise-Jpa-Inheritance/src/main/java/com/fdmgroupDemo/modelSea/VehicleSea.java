package com.fdmgroupDemo.modelSea;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "Vehicle_Type")
@Entity
public abstract class VehicleSea 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID")
	private int Id;
	
	@Column(name = "NAME")
	private String Name;

	
	
	
	public Integer getId() {return Id;}		public void setId(Integer id) {Id = id;}
	public String getName() {return Name;	}	public void setName(String name) {Name = name;}
	
	
	
}
