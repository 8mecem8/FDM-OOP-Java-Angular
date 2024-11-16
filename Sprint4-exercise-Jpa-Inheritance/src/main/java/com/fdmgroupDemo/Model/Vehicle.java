package com.fdmgroupDemo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Vehicle_Type")
@Entity
public abstract class Vehicle 
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
