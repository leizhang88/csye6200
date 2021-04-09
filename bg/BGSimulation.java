/**
 * Assignment 5: Biological Growth
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.bg;

import java.util.Observable;

public class BGSimulation extends Observable implements Runnable {
	
	private Thread thread = null;
	private boolean done = false; // Set true to end the simulation loop
	private boolean paused = false; // Set true to pause the simulation loop
	private int ctr = 0;
	
	private double lenRoot = 100; // Set initial length of the root stem
	private double dirRoot = 0; // Set direction of the root stem
	
	private int XStart = 0;
	private int YStart = 300;
	private Stem root;
	private BGRule rule;  
	private BGGeneration gen;
	private BGGenerationSet genSet;
	
	
	/**
	 * Constructor
	 */
	public BGSimulation() {
		System.out.println("Constructing the BGSimulation");
		//rule = new BGRule1();
		
	}
	
	/**
	 * Start the simulation
	 */
	public void startSim() {
		System.out.println("Starting the simulation");
		
		if (thread == null) 
			thread = new Thread(this); // We are the Runnable
		
		thread.start();
	}
	
	/**
	 * Toggle the paused state between off/on
	 */
	public void pauseSim() {
		paused = !paused; // Flip the paused state
		System.out.println("Pause state is " + paused);
	}
	
	/**
	 * Stop the simulation
	 */
	public void stopSim() {
		System.out.println("Stopping the simulation");
		if (thread == null) return;
		done = true; // Stop an existing simulation loop
	}

	@Override
	public void run() {
		runSimLoop(); // Run the simulation
		thread = null;
	}
	
	/**
	 * The main simulation loop
	 */
	private void runSimLoop() {
		root = new Stem(XStart, YStart, lenRoot, dirRoot, 0, null);
		gen = BGGeneration.createAndGrow(root, 0, rule);
		genSet = BGGenerationSet.getInstance(gen);
		
		while(!done) {
			if (!paused) 
				updateSim(); // Advance the simulation
			sleep(500L);
		}
	}
	
	/**
	 * Perform a thread sleep
	 * @param millis time to sleep in millisecond
	 */
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Perform an update to our simulation - cause growth to occur
	 */
	private void updateSim() {
		if (ctr == 0) {
			System.out.println("\n>>>Root has been planted.");
		} else if (ctr > 0 & ctr <= rule.getAgeElongate()) {
			genSet.update(ctr);
		} else if (ctr > rule.getAgeElongate() & ctr < rule.getMaxAge()) {
			root.grow(rule.getLenFactor1());
			gen = BGGeneration.createAndGrow(root, ctr, rule);
			genSet.update(gen);
		} else {
			root.grow(rule.getLenFactor2());
			gen = BGGeneration.createAndGrow(root, rule.getMaxAge(), rule);
			genSet.update(gen);
		}
		
		setChanged(); // Indicate that new data is available
		notifyObservers(genSet.currGen);
		//gen.getTreeHeight();
		
		//System.out.println(ctr + ", " + genSet.currGen);
		ctr++;
		
		if (ctr > rule.getMaxCtr()) {
			done = true;
			System.out.println("\n>>>Simulation is done.");
		}
	}
	
	/**
	 * Reset variables
	 */
	public void resetSim() {
		ctr = 0;
		done = false;
		paused = false;
		gen = null;
		genSet = null;
	}

	public void setRule(BGRule rule) {
		this.rule = rule;
	}

}
