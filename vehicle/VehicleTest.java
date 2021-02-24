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
		System.out.println("***Test 1***\nCreate an instance of TruckVehicle:");
		TruckVehicle truck = new TruckVehicle("GMC", "Canyon", 2021, "'TCD010'", 2, 50, 45.0, 2.0, 1.9, 2.4); 
		System.out.println("Truck:   " + truck.toFormattedString() + "\n");
		
		
		System.out.println("\n***Test 2***\nGenerate a Vehicle list:");
		// Created three instances of class Vehicle
		Vehicle minivan = new Vehicle("Ford", "Fusion", 2016, "'UZM981'", 6, 30, 25.0); 
		Vehicle sportscar = new Vehicle("Chevrolet", "Corvette", 2020, "'522NTR'", 2, 20, 40); 
		Vehicle sedan = new Vehicle("Lexus", "LS", 2021, "'ABC123'", 4, 40, 33.2); 
		
		// Add Vehicles to the list
		VehicleRegistry vr = new VehicleRegistry(); 
		vr.add(minivan);
		vr.add(sportscar);
		vr.add(sedan);
		
		vr.list(); // Display all the vehicles in the ArrayList
		
		
		String fileName = "src/edu/neu/csye6200/vehicle/VehicleIOTest.txt";
		RentalAgencyIO raIO = new RentalAgencyIO();
		
		System.out.println("\nWriting to the file...");
		raIO.save(vr, fileName); // Save the Vehicle list to the file
		
		System.out.println("\nLoading from the file and print out the new vehicle list...");
		VehicleRegistry vrNew = new VehicleRegistry();
		raIO.load(vrNew, fileName);
		vrNew.list();
		
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
