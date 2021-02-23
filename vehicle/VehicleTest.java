/**
 * CSYE 6200 Assignment #2 starter file
 */

/**
 * A special class used to test the Vehicle class
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.vehicle;

public class VehicleTest {

	public VehicleTest() {
	}
	
	/**
	 * Do work here
	 */
	public void run() {
		// Created three instances of class Vehicle
		Vehicle minivan = new Vehicle(6, 30, 25.0, "Ford", "Fusion", 2016, "UZM 981"); 
		Vehicle sportscar = new Vehicle(2, 20, 40, "Chevrolet", "Corvette", 2020, "522 NTR"); 
		Vehicle sedan = new Vehicle(4, 40, 33.2, "Lexus", "LS", 2021, "ABC 123"); 
		
		VehicleRegistry vr = new VehicleRegistry(); // Create an instance of VehicleRegistry
		
		// Add the vehicles to the ArrayList and the HashMap
		vr.add(minivan);
		vr.add(sportscar);
		vr.add(sedan);
		System.out.println("Added three vehicles\n");
		
		vr.list(); // Display all the vehicles in the ArrayList
		
		Vehicle car = vr.retrieve("ABC 123"); // Retrieve a vehicle with the given license from the HsahMap
		System.out.println("\nRetrieve a vehicle with the licnese palte \'ABC 123\'\n");
		
		vr.list(); // Display again
		
		
	}
	
	/**
	 * Program starts here
	 * @param args
	 */
	public static void main(String[] args) {
		VehicleTest vt = new VehicleTest();
		vt.run();
		
	}
}
