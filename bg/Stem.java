/**
 * Assignment 5: Biological Growth
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.bg;

import java.awt.Color;
import java.util.ArrayList;

public class Stem {
	
	private Stem parent = null;
	private ArrayList<Stem> childStem = new ArrayList<Stem>();
	private int age; // Age starts at 0 (root)
	private double length;
	private Color color;
	private int width;
	
	// Direction of a stem is defined as the angle
	// rotating from the vertical axis to the stem,
	// being positive if the stem deflects towards 
	// right and negative for left.
	private double direction;
	
	// Coordinates of the start point
	private int XStart;
	private int YStart;
	
	// Coordinates of the end point
	private int XEnd;
	private int YEnd;

	/**
	 * Constructor
	 */
	public Stem(int x, int y, double len, double dir, int a, Stem p) {
		XStart = x;
		YStart = y;
		length = len;
		direction = dir;
		age = a;
		parent = p;
	}
	
	/**
	 * Make the stem grow by the given factor
	 * @param factor
	 */
	public void grow(double factor) {
		this.length *= factor;
	}
	
	/**
	 * Calculate the end point coordinates
	 */
	public void calcEnd() {
		XEnd = (int) (XStart + Math.round(length * Math.sin(Math.toRadians(direction))));
		YEnd = (int) (YStart - Math.round(length * Math.cos(Math.toRadians(direction))));
	}

	public ArrayList<Stem> getChildStem() {
		return childStem;
	}

	public void setChildStem(ArrayList<Stem> childStem) {
		this.childStem = childStem;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public int getXStart() {
		return XStart;
	}

	public void setXStart(int xStart) {
		this.XStart = xStart;
	}

	public int getYStart() {
		return YStart;
	}

	public void setYStart(int yStart) {
		this.YStart = yStart;
	}

	public int getXEnd() {
		return XEnd;
	}

	public void setXEnd(int xEnd) {
		this.XEnd = xEnd;
	}

	public int getYEnd() {
		return YEnd;
	}

	public void setYEnd(int yEnd) {
		this.YEnd = yEnd;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Stem getParent() {
		return parent;
	}

}
