package com.fdmgroupDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroupDemo.Model.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Integer> {

}
