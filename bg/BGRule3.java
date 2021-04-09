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
 * The third rule
 */
public class BGRule3 extends BGRule {
	
	private int maxAge = 7;
	private double lenFactor1 = 1.1;
	private double lenFactor2 = 1.04;
	private int maxCtr = 12;

	private double midLenFactor = 1.25;
	private double sideLenFactor = 0.8;
	
	/**
	 * Constructor
	 */
	public BGRule3() {
	}

	@Override
	public void makeChild(Stem p) {
		ArrayList<Stem> childStem = new ArrayList<Stem>();
		int age = p.getAge();
		double dir = p.getDirection();
		p.calcEnd(); // Calculate end point of parent stem
		int XEnd = p.getXEnd();
		int YEnd = p.getYEnd();
		double childLen = p.getLength() * extLenRatio; // Length of child stem
		
		// Generate child stems
		childStem.add(new Stem(XEnd, YEnd, childLen * sideLenFactor, 
				(dir - extAngle), age + 1, p));
		childStem.add(new Stem(XEnd, YEnd, childLen * midLenFactor, 
				dir, age + 1, p));
		childStem.add(new Stem(XEnd, YEnd, childLen * sideLenFactor, 
				(dir + extAngle), age + 1, p));
		
		p.setChildStem(childStem);
	}

	@Override
	public void makeColor(Stem s) {
		int x = s.getAge();
		if (x < colors.length)
			s.setColor(colors[s.getAge()]);
		else
			s.setColor(colors[colors.length - 1]);
	}

	@Override
	public void makeWidth(Stem s) {
		s.setWidth(2);
	}

	public int getMaxCtr() {
		return maxCtr;
	}

	public double getLenFactor1() {
		return lenFactor1;
	}

	public double getLenFactor2() {
		return lenFactor2;
	}

	public int getMaxAge() {
		return maxAge;
	}

}
