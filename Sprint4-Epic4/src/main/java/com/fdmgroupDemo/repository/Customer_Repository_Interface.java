package com.fdmgroupDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroupDemo.model.Customer;



public interface Customer_Repository_Interface extends JpaRepository<Customer, Long>
{
	
}
