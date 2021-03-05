/**
 * A special class to store Vehicle
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.agency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Logger;

public class VehicleRegistry {
	
	// Create a single pattern
	private static VehicleRegistry instance = null;
	
	/**
	 * Private constructor
	 */
	private VehicleRegistry() {
	}
		
	public static VehicleRegistry instance() {
		if (instance == null) 
			instance = new VehicleRegistry();
		return instance;
	}
	
	private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	private HashMap<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();

	// Add logging
	private static Logger log = 
			Logger.getLogger(VehicleRegistry.class.getName());
	
	/**
	 * Add a Vehicle to the ArrayList as well as the HashMap
	 * @param car the Vehicle to add
	 */
	public void add(Vehicle car) {
		vehicleList.add(car);
		vehicleMap.put(car.license, car);
		log.info("Added a vehicle");
	}
	
	/**
	 * Remove a Vehicle from the ArrayList and the HashMap
	 * @param car the Vehicle to remove
	 */
	public void remove(Vehicle car) {
		vehicleList.remove(car);
		vehicleMap.remove(car.license);
		log.info("Removed a vehicle");
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
		System.out.println("**Vehicles in Registry**");
		//System.out.println("         Manufacturer      Model   Year    License  Pass.   Fuel    KPL  Range");
		for (Vehicle car : vehicleList) {
			System.out.println(car.toFormattedString());
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
	
	/**
	 * Get the Vehicle list size
	 * @return the size of the Vehicle list
	 */
	public int getSize() {
		return vehicleList.size();
		
	}
	
	/**
	 * Sort the vehicle list by the license plate by making a call to the actual quicksort method
	 */
	public void sort() {
		qs(vehicleList, 0, getSize() - 1);
	}
	
	/**
	 * A recursive version of Quicksort 
	 * @param vl
	 * @param left
	 * @param right
	 */
	private void qs(ArrayList<Vehicle> vl, int left, int right) {
		int i = left;
		int j = right;
		
		String x = vl.get((i + j) / 2).license;
		
		do {
			while ((vl.get(i).license.compareTo(x) < 0) && (i < right)) i++;
			while ((vl.get(j).license.compareTo(x) > 0) && (left < j)) j--;
			
			if (i <= j) {
				Collections.swap(vl, i, j);
				i++;
				j--;
			}
		} while (i <= j);
			
		if (i < right) qs(vl, i, right);
		if (left < j) qs(vl, left, j);
	}
	
}
