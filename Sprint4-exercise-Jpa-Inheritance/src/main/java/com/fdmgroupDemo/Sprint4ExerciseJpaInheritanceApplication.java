package com.fdmgroupDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fdmgroupDemo.Model.Bike;
import com.fdmgroupDemo.Model.Car;
import com.fdmgroupDemo.Model.Vehicle;
import com.fdmgroupDemo.Repository.VehicleAirRepo;
import com.fdmgroupDemo.Repository.VehicleRepo;
import com.fdmgroupDemo.Repository.VehicleSeaRepo;
import com.fdmgroupDemo.Repository.VehicleSpaceRepo;
import com.fdmgroupDemo.modelAir.Heli;
import com.fdmgroupDemo.modelAir.Plane;
import com.fdmgroupDemo.modelAir.VehicleAir;
import com.fdmgroupDemo.modelSea.Boat;
import com.fdmgroupDemo.modelSea.Ship;
import com.fdmgroupDemo.modelSea.VehicleSea;
import com.fdmgroupDemo.modelSpace.Rocket;
import com.fdmgroupDemo.modelSpace.Shuttle;
import com.fdmgroupDemo.modelSpace.VehicleSpace;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@SpringBootApplication
public class Sprint4ExerciseJpaInheritanceApplication 
{
	@PersistenceContext
    private EntityManager entityManager;
	
	public static void main(String[] args){SpringApplication.run(Sprint4ExerciseJpaInheritanceApplication.class, args);}
	 
	
	@Bean 
	public CommandLineRunner commandLineRunner(VehicleRepo vehicleRepository, VehicleAirRepo vehicleAirRepo, VehicleSeaRepo vehicleSeaRepo, VehicleSpaceRepo vehicleSpaceRepo) {
	    return args -> 
	    {
	        // Persisting data 
	        Car car = new Car();
	        car.setName("Sedan");   car.setNumberOfDoors(4);

	        Bike bike = new Bike();
	        bike.setName("Mountain Bike");  bike.setHasCarrier(true);
 
	        vehicleRepository.save(car);  vehicleRepository.save(bike);

	        // Querying data
	        //List<Vehicle> vehicles = vehicleRepository.findAll();
	        for (Vehicle vehicle : vehicleRepository.findAll()) {System.out.println("\nVehicle Name: " + vehicle.getName() + "\nID:" + vehicle.getId());}
	        
	        
	        /*###################################################################################################################*/ System.out.println("\n################################################################################\n");
	        
	        // Persisting data 
	        Plane plane = new Plane();
	        plane.setName("f15a");   plane.setNumberOfDoors(1);
	        
	        Heli heli = new Heli();
	        heli.setName("Apache");  heli.setHasCarrier(false);
	        
	        vehicleAirRepo.save(plane);  vehicleAirRepo.save(heli);
	        
	        // Querying data
	        for (VehicleAir vehicle : vehicleAirRepo.findAll()) {System.out.println("Vehicle Name: " + vehicle.getName()+ "\nID:" + vehicle.getId() + "\n");}
	        
	        
	        /*###################################################################################################################*/ System.out.println("\n################################################################################\n");
	        
	        // Persisting data 
	        Boat boat = new Boat();
	        boat.setName("Hudson Boat");   boat.setNumberOfDoors(1);
	        
	        Ship ship = new Ship();
	        ship.setName("Lake Ship");  ship.setHasCarrier(false);
	        
	        vehicleSeaRepo.save(ship);  vehicleSeaRepo.save(boat);
	        
	        // Querying data
	        for (VehicleSea vehicle : vehicleSeaRepo.findAll()) {System.out.println("Vehicle Name: " + vehicle.getName()+ "\nID:" + vehicle.getId() + "\n");}
	        
	        
	        
	        /*###################################################################################################################*/ System.out.println("\n################################################################################\n");
	        
	        
	        // Persisting data 
	        Rocket rocket = new Rocket();
	        rocket.setName("Space Rocket");   rocket.setNumberOfDoors(1);
	        
	        Shuttle shuttle = new Shuttle();
	        shuttle.setName("Space Shuttle");  shuttle.setHasCarrier(false);
	        
	        vehicleSpaceRepo.save(shuttle);  vehicleSpaceRepo.save(rocket);
	        
	        // Querying data
	        for (VehicleSpace vehicle : vehicleSpaceRepo.findAll()) {System.out.println("Vehicle Name: " + vehicle.getName()+ "\nID:" + vehicle.getId() + "\n");}
	    };
	}

}
