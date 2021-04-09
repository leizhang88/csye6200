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

/**
 * The second rule
 */
public class BGRule2 extends BGRule {

	private int maxAge = 10;
	private int ageElongate = 3;
	private double extLenRatio = 0.618;
	private double extAngle = 30;
	private double lenFactor1 = 1.08;
	private double lenFactor2 = 1.03;
	private int maxCtr = 15;


	/**
	 * Constructor
	 */
	public BGRule2() {
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
		childStem.add(new Stem(XEnd, YEnd, childLen, 
				(dir - extAngle), age + 1, p));
		childStem.add(new Stem(XEnd, YEnd, childLen, 
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
		if (s.getAge() == 0) { // if root
			int a = maxChildAge(s);
			if (a <= ageElongate)
				s.setWidth(2);
			else {
				int w = s.getWidth();
				w = ((w + 2) < 10) ? (w + 2) : 10;
				s.setWidth(w);
			} 
		} else {
			int wp = s.getParent().getWidth();
			int w = ((wp - 2) > 2) ? (wp - 2) : 2;
			s.setWidth(w);
		}
	}


	private int maxChildAge(Stem p) {
		int res = 0;
		Stem c = p;
		while (c.getChildStem().size() != 0) {
			res++;
			c = c.getChildStem().get(0);
		}
		return res;
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

	public int getMaxCtr() {
		return maxCtr;
	}

	public Color[] getColors() {
		return colors;
	}

}
