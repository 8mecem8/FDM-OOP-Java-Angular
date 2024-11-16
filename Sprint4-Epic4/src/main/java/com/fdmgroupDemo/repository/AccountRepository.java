package com.fdmgroupDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fdmgroupDemo.model.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Integer> 
{
	@Query("SELECT a FROM Account a WHERE a.customer.address.city = :city")
    List<Account> findAllByCustomerCity(@Param("city") String city);

}