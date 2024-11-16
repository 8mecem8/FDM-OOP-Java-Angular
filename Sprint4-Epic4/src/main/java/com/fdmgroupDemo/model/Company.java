package com.fdmgroupDemo.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMPANY")
public class Company extends Customer
{
   
}
