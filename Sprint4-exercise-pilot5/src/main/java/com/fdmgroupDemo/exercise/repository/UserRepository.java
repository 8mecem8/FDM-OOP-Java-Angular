package com.fdmgroupDemo.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroupDemo.exercise.model.User;


public interface UserRepository extends JpaRepository<User, Long> 
{
    User findByUsername(String username);
}
