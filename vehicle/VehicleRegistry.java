/**
 * A special class to store Vehicle
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.vehicle;

import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
	
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private HashMap<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();

	/**
	 * Constructor
	 */
	public VehicleRegistry() {
	}
	
	/**
	 * Add a Vehicle to the ArrayList as well as the HashMap
	 * @param car the Vehicle to add
	 */
	public void add(Vehicle car) {
		vehicleList.add(car);
		vehicleMap.put(car.license, car);
	}
	
	/**
	 * Remove a Vehicle from the ArrayList and the HashMap
	 * @param car the Vehicle to remove
	 */
	public void remove(Vehicle car) {
		vehicleList.remove(car);
		vehicleMap.remove(car.license);
	}
	
	/**
	 * Get the Vehicle of given index
	 * @param i the index of the ArrayList
	 * @return the Vehicle
	 */
	public Vehicle get(int i) {
		if (i >= vehicleList.size()) {
			System.out.println("Error: index out of bounds");
			return null;
		} else 
			return vehicleList.get(i);
	}
	
	/**
	 * Display the ArrayList to the screen
	 */
	public void list() {
		System.out.println("Vehicles in registry:");
		System.out.println("         Manufacturer      Model   Year    License  Pass.   Fuel    KPL    Range");
		for (Vehicle car : vehicleList) {
			System.out.println("Vehicle: " + car.toFormattedString());
		}
	}
	
	/**
	 * Retrieve a Vehicle from the HashMap and remove it from both the ArrayList and the HashMap
	 * @param license the license of the Vehicle
	 * @return the matched Vehicle
	 */
	public Vehicle retrieve(String license) {
		if (!vehicleMap.containsKey(license)) {
			System.out.println(license + " not found.");
			return null;
		} else {
			Vehicle car = vehicleMap.get(license);
			remove(car);
			return car;
		}
	}
	
}
