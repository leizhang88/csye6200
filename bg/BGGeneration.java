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
 * Store the BG generation in a jagged 2D array
 */
public class BGGeneration {

	public Stem root; // Root stem of BGG
	public int maxAge; // The maximum age allowed to grow in the BG generation
	public ArrayList<Stem>[] bgg = null; // Jagged 2D array
	public BGRule rule;

	/**
	 * Constructor
	 */
	private BGGeneration(Stem root, int maxAge, BGRule rule) {
		this.root = root;
		this.maxAge = maxAge;
		this.rule = rule;

		// Initializing
		bgg = new ArrayList[maxAge+1];
		for (int i = 0; i <= maxAge; i++) 
			bgg[i] = new ArrayList<Stem>();
		bgg[0].add(root);
	}

	/**
	 * Static factory - create an instance and call grow()
	 * @param root the root stem
	 * @param maxAge the max age allowed to grow
	 * @param rule the BG rule
	 * @return a fully grown BG generation
	 */
	public static BGGeneration createAndGrow(Stem root, int maxAge, BGRule rule) {
		BGGeneration generation = new BGGeneration(root, maxAge, rule);
		generation.grow();
		return generation;
	}


	/**
	 * Generate a whole BG generation by a single call
	 */
	public void grow() {
		rule.makeChild(root); // Generate child stems of root
		// Generate child stems for all the stem
		for (int i = 1; i < maxAge; i++) {
			if (i == 1) 
				bgg[1] = bgg[0].get(0).getChildStem();
			for (Stem c : bgg[i]) {
				rule.makeChild(c);
				for (Stem s : c.getChildStem()) { 
					bgg[i+1].add(s); 
				}
			}
		}

		// Set color and width
		for (int i = 0; i <= maxAge; i++) {
			for (Stem s : bgg[i]) {
				rule.makeColor(s);
				rule.makeWidth(s);
			}
		}

	}

	/**
	 * Obtain the tree height for scaled rendering
	 * @return the height of tree
	 */
	public int getTreeHeight() {
		int peak = root.getYStart();
		for (int i = 0; i<= maxAge; i++) {
			if (bgg[i].size() != 0) {
				for (Stem s : bgg[i]) {
					s.calcEnd();
					peak = (s.getYEnd() < peak) ? s.getYEnd() : peak;
				}
			}
		}
		return root.getYStart() - peak;
	}


	/**
	 * Display the BG generation to the screen
	 */
	public void list() {
		System.out.println("BG Tree listed by age:");
		if (bgg[0].size() != 0) { // Check that the root stem exists
			Stem root = bgg[0].get(0);
			System.out.println("Start point: (" + root.getYStart() + "," + root.getYStart() + ")");
		}

		for (int i = 0; i <= maxAge; i++) {
			if (bgg[i].size() != 0) { // Make sure the i-th row of bgg is nonempty
				System.out.print("Age" + String.format("%02d", i) + ": ");
				int counter = 0;
				for (Stem s : bgg[i]) {
					s.calcEnd();
					System.out.print("(" + s.getXEnd() + "," + s.getYEnd() + ") ");
					counter++;
					if (counter == 9 & s != bgg[i].get(bgg[i].size()-1)) { // At most 9 outputs each line
						System.out.println();
						System.out.print("       ");
						counter = 0;
					}
				}
				System.out.println();
			}
		}
	}

}
