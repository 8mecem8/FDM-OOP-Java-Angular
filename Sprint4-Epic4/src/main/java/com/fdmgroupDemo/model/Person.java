package com.fdmgroupDemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
@Entity
@DiscriminatorValue("PERSON")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person extends Customer
{
	//private String name; // bu aq seyini testleri gecmek icin acman gerek !!!!!
	
	
	
}