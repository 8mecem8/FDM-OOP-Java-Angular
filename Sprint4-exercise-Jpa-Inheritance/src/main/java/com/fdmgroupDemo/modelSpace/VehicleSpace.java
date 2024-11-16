package com.fdmgroupDemo.modelSpace;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
@DiscriminatorColumn(name = "Vehicle_Type")
public abstract class VehicleSpace 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int Id;
	
	@Column(name = "NAME")
	private String Name;

	
	
	
	public Integer getId() {return Id;}		public void setId(Integer id) {Id = id;}
	public String getName() {return Name;	}	public void setName(String name) {Name = name;}
	
	
	
}
