package com.fdmgroupDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroupDemo.modelSpace.VehicleSpace;

public interface VehicleSpaceRepo extends JpaRepository<VehicleSpace, Integer> {

}
