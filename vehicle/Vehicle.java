/**
 * CSYE 6200 Vehicle starter class
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.vehicle;

public class Vehicle {
	
	int passengers; // number of passengers
	int fuelCap; // fuel tank size in liters
	double kpl; // kilometers per liter
	String make; // the manufacturer
	String model; // model of the vehicle
	int modelYear; // the model year
	String license; // the license
	
	/**
	 * Constructor
	 */
	public Vehicle() {
		passengers = 4; // Sedan
		fuelCap = 20;
		kpl = 20.0;
	}
	
	/**
	 * Constructor that sets the instance variables through arguments
	 * @param passengers the number of passengers
	 * @param fuelCap fuel tank size in liters
	 * @param kpl kilometers per liter
	 * @param make the manufacturer
	 * @param model the model of the vehicle
	 * @param modelYear the year of the model
	 * @param license the license of the vehicle
	 */
	public Vehicle(String make, String model, int modelYear, String license, int passengers, int fuelCap, double kpl) {
		this.passengers = passengers;
		setPassengers(passengers);
		this.fuelCap = fuelCap;
		this.kpl = kpl;
		this.make = make;
		this.model = model;
		this.modelYear = modelYear;
		this.license = license;
	}
	
	/**
	 * Setter for the number of passengers
	 * @param passengers the count of passengers in the vehicle
	 */
	public void setPassengers(int passengers) {
		if (passengers < 1) this.passengers = 1;
	}
	
	/**
	 * Range of the vehicle
	 * @return range in kilometers
	 */
	public int range() {
		return (int) (fuelCap * kpl);
	}
	
	/**
	 * Get the license
	 * @return the license
	 */
	public String getLicense() {
		return license;
	}
	
	/**
	 * Print out in formatted style
	 * @return a formatted string of instance variables
	 */
	public String toFormattedString() {
		return String.format("Vehicle,%1$12s,%2$10s,%3$6d,%4$10s,%5$6d,%6$6d,%7$6.1f,%8$6d",
				make, model, modelYear, license, passengers, fuelCap, kpl, range());
	}
	
	
	/**
	 * ToString - converts this class into textual string form
	 */
	public String toString() {
		
		return "Vehicle" + 
		", make=" + make +
		", model=" + model +
		", modelYear=" + modelYear +
		", license=" + license +
		", passengers=" + passengers +
		", fuelCap=" + fuelCap + 
		", kpl=" + kpl;
	}

}
