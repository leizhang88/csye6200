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
 * Hold multiple BG generations
 */
public class BGGenerationSet {
	
	private int maxLen; // Max set length
	
	public ArrayList<BGGeneration> genList = new ArrayList<BGGeneration>();
	public BGGeneration currGen = null; // The newest BGG in the list

	/**
	 * Constructor
	 */
	private BGGenerationSet() {
		maxLen = 2; // Store two BGG by default
	}
	
	/**
	 * Static factory - create an initialized instance
	 * @param bgg the initializing BG generation
	 */
	public static BGGenerationSet getInstance(BGGeneration bgg) {
		BGGenerationSet genSet = new BGGenerationSet();
		genSet.update(bgg);
		return genSet;
	}
	
	/**
	 * Update the set with a given BGG
	 */
	public void update(BGGeneration nextGen) {
		genList.add(nextGen);
		currGen = nextGen;
		
		while (genList.size() > maxLen)
			genList.remove(0);
	}
	
	/**
	 * Update the set by setting a new maxAge
	 */
	public void update(int newMaxAge) {
		if (genList.size() == 0) {
			System.out.println("**BG GENERATION SET IS EMPTY - ADD A GENERATION FIRST**");
			return;
		}
		
		BGGeneration nextGen = BGGeneration.createAndGrow(currGen.root, newMaxAge, currGen.rule);
		genList.add(nextGen);
		currGen = nextGen;
		
		while (genList.size() > maxLen)
			genList.remove(0);
	}
	
}
