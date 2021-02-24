/**
 * CSYE 6200 Assignment 4
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.vehicle;

public class TruckVehicle extends Vehicle {

	double height; // Height of the cargo hold
	double width; // Width of the cargo hold
	double length; // Length of the cargo hold
	
	/**
	 * Constructor
	 * @param height the height of the cargo hold
	 * @param width the width of the cargo hold
	 * @param length the length of the cargo hold
	 */
	public TruckVehicle(String make, String model, int modelYear, String license, 
			int passengers, int fuelCap, double kpl, double height, double width, 
			double length) {
		
		// Use super() to execute the Vehicle constructor
		super(make, model, modelYear, license, passengers, fuelCap, kpl);
		
		this.height = height;
		this.width = width;
		this.length = length;
	}
	
	/**
	 * Get the cargo area
	 * @return the cargo area
	 */
	public double getArea() {
		return width * length;
	}
	
	public String toFormattedString() {
		return super.toFormattedString() + String.format(" %1$6.2f", getArea());
	}

}
