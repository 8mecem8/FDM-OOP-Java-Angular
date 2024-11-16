package com.fdmgroupDemo.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("SAVINGS")
public class SavingsAccount extends Account 
{
    @NotNull
    @Column(nullable = false)
    private Double interestRate;

    
    
	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

   
}
