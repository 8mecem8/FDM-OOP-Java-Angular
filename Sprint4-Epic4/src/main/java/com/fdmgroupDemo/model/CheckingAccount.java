package com.fdmgroupDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("CHECKING")
public class CheckingAccount extends Account 
{
    
    @Column(nullable = true)
    private Integer nextCheckNumber;

    
	public Integer getNextCheckNumber() {
		return nextCheckNumber;
	}

	public void setNextCheckNumber(Integer nextCheckNumber) {
		this.nextCheckNumber = nextCheckNumber;
	}

    
}
