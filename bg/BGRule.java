/**
 * Assignment 5: Biological Growth
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.bg;

import java.awt.Color;

/**
 * Specify the rule by which the tree grows
 */
public abstract class BGRule {
	
	protected int maxAge = 9; // The maximum age of stem in a BG generation. Default is 9
	protected int ageElongate = 3; // Stems start to elongate after reaching this age. Default is 3
	protected double extLenRatio = 0.5; // Extending length ratio. Default is 0.618
	protected double extAngle = 60; // Extending angle. Default is 60
	protected double lenFactor1 = 1.0; // Growing factor of stem length. Default is 1.0
	protected double lenFactor2 = 1.0;
	protected int maxCtr = 18; // The maximum running counts.
	
	protected Color[] colors = new Color[] { // Default palette
			new Color(114, 45, 97),
			new Color(192, 92, 126),
			new Color(243, 130, 111),
			new Color(255, 185, 97),
			new Color(141, 198, 67),
			new Color(79, 168, 68),
			new Color(17, 135, 69)
	};

	/**
	 * Constructor
	 */
	public BGRule() {
	}
	
	/**
	 * Override this method to specify the generation of child stems
	 * @param p the parent Stem
	 */
	public abstract void makeChild(Stem p);
	
	/**
	 * Override this method to set color to the stem
	 * @param s the Stem instance
	 */
	public abstract void makeColor(Stem s);
	
	/**
	 * Override this method to set width to the stem
	 * @param s
	 */
	public abstract void makeWidth(Stem s);

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

}
