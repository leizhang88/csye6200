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
package edu.neu.csye6200.agency;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class VehicleTest {

	public VehicleTest() {
	}
	
	/**
	 * Do work here
	 */
	public void run() {
		
		// Generate a FileHandler to save logging messages to disk
		try {
			Handler handler = new FileHandler("src/edu/neu/csye6200/agency/server.log");
			Logger.getLogger("").addHandler(handler);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Created instances of class Vehicle
		Vehicle minivan = new Vehicle("Ford", "Fusion", 2016, "'UZM 981'", 6, 30, 25.0); 
		Vehicle sportscar = new Vehicle("Chevrolet", "Corvette", 2020, "'522 NTR'", 2, 20, 40); 
		Vehicle sedan = new Vehicle("Lexus", "LS", 2021, "'ABC 123'", 4, 40, 33.2);
		Vehicle coupe = new Vehicle("Dodge", "Challenger", 2010, "'SLJ REW'", 2, 34, 30);
		Vehicle convertible = new Vehicle("Porsche", "911", 2019, "'LEK 3XJ'", 2, 28, 29);
		Vehicle suv = new Vehicle("Mercedes-Benz", "GLA", 2008, "'ZPO 992'", 4, 50, 36);
		Vehicle jeep = new Vehicle("Jeep", "Wrangler", 2017, "'203 WRP'", 5, 48, 30);
		Vehicle hatchback = new Vehicle("Volkswagen", "Golf", 2020, "'E4K CBC'", 5, 32, 40.8);
		Vehicle wagon = new Vehicle("Audi", "A6", 2021, "'ELL 942'", 4, 50, 35.6);
		Vehicle pickup = new Vehicle("Ford", "Ranger", 2012, "'AMC LWE'", 2, 48, 44.2);
		
		// Add Vehicles to the list
		VehicleRegistry vr = VehicleRegistry.instance(); 
		vr.add(minivan);
		vr.add(sportscar);
		vr.add(sedan);
		vr.add(coupe);
		vr.add(convertible);
		vr.add(suv);
		vr.add(jeep);
		vr.add(hatchback);
		vr.add(wagon);
		vr.add(pickup);
		
		// Add sedan again and remove 
		vr.add(sedan);
		vr.remove(sedan);
		
		System.out.println("Before sorting\n");
		vr.list(); // Display all the vehicles in the ArrayList
		vr.sort();
		System.out.println("\nAfter sorting\n");
		vr.list();
		
		
		String fileName = "src/edu/neu/csye6200/agency/VehicleIOTest.txt";
		RentalAgencyIO raIO = new RentalAgencyIO();
		
		System.out.println("\nWriting to the file...");
		raIO.save(vr, fileName); // Save the Vehicle list to the file
		
		System.out.println("\nLoading from the file...");
		System.out.println("\nThis is the new Vehicle list");
		VehicleRegistry vrNew = VehicleRegistry.instance();
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
