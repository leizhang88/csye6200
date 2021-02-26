/**
 * CSYE 6200 Assignment 4
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.vehicle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RentalAgencyIO {
	
	/**
	 * Constructor
	 */
	public RentalAgencyIO() {
	}
	
	/**
	 * Write an object of Vehicle the given file
	 * @param car the Vehicle object
	 * @param writer the FileWriter object
	 */
	private void save(Vehicle car, FileWriter writer) {
		try {
			writer.write(car.toFormattedString() + '\n');
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Error occurred when writing item: " + car.toString());
		}
	}
	
	/**
	 * Write an array of Vehicle to the file
	 * @param vr an object of VehicleRegistry that has a private array member of Vehicle
	 * @param fileName the file to write into
	 */
	public void save(VehicleRegistry vr, String fileName) {
		FileWriter writer;
		try {
			writer = new FileWriter(fileName);
			
			for (int i = 0; i < vr.getSize(); i++)
				save(vr.get(i), writer);
			
			writer.close();
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Error occurred when writing into file: " + fileName);
		} 
		
	}
	
	public void load(VehicleRegistry vr, String fileName) {
		String[] values;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			
			String line = reader.readLine();
			while (line != null) {
				// Extract values from each line
				values = line.split(","); 
				for (int i = 0; i < values.length; i++) {
					values[i] = values[i].trim();
				}
				
				// Create an instance of Vehicle
				Vehicle car = new Vehicle(values[1], values[2], Integer.parseInt(values[3]), values[4], 
						Integer.parseInt(values[5]), Integer.parseInt(values[6]), Double.parseDouble(values[7]));
				
				vr.add(car); // Add to the Vehicle array
				
				line = reader.readLine(); // Read next line
			}
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: can't find file " + fileName);
		} catch (IOException e) {
			System.out.println("Error occurred when reading file: " + fileName);
		}
		
		
	}

}
