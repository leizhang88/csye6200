/**
 * Assignment 5: Biological Growth
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.bg;

import java.util.ArrayList;

/**
 * Extend an existing stem by the rule
 */
public class BGRule1 extends BGRule {
	
	private int maxAge = 9;
	private int ageElongate = 4; // Stems start to elongate after reaching this age
	private double extLenRatio = 0.5;
	private double extAngle = 120;
	private double lenFactor1 = 1.1;
	private double lenFactor2 = 1.1 * 0.95;

	/**
	 * Constructor
	 */
	public BGRule1() {
	}
	
	public void makeChild(Stem p) {
		ArrayList<Stem> childStem = new ArrayList<Stem>();
		int age = p.getAge();
		double dir = p.getDirection();
		p.calcEnd(); // Calculate end point of parent stem
		int XEnd = p.getXEnd();
		int YEnd = p.getYEnd();
		double childLen = p.getLength() * extLenRatio; // Length of child stem
		
		// Generate child stems
		childStem.add(new Stem(XEnd, YEnd, childLen, 
				(dir - extAngle), age + 1, p));
		childStem.add(new Stem(XEnd, YEnd, childLen, 
				dir, age + 1, p));
		childStem.add(new Stem(XEnd, YEnd, childLen, 
				(dir + extAngle), age + 1, p));
		
		p.setChildStem(childStem);
	}
	
	@Override
	public void makeColor(Stem s) {
		s.setColor(colors[colors.length - 1]);
	}
	
	@Override
	public void makeWidth(Stem s) {
		s.setWidth(1);
	}

	public int getMaxAge() {
		return maxAge;
	}

	public double getExtLenRatio() {
		return extLenRatio;
	}

	public double getExtAngle() {
		return extAngle;
	}

	public double getLenFactor1() {
		return lenFactor1;
	}

	public double getLenFactor2() {
		return lenFactor2;
	}

	public int getAgeElongate() {
		return ageElongate;
	}

}
