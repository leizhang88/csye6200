/**
 * Assignment 5: Biological Growth
 * 
 * @author Lei Zhang
 * NUID: 001082325
 * 
 */
package edu.neu.csye6200.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.neu.csye6200.bg.BGRule1;
import edu.neu.csye6200.bg.BGRule2;
import edu.neu.csye6200.bg.BGRule3;
import edu.neu.csye6200.bg.BGSimulation;
import net.java.dev.designgridlayout.DesignGridLayout;

public class MyAppUI extends BGApp implements ActionListener {

	private JPanel mainPanel;
	private JButton startBtn;
	private JButton pauseBtn;
	private JButton stopBtn;
	private JButton resetBtn;
	private MyCanvas canvas;
	private JLabel label1;
	private JLabel label2;
	private JComboBox<String> comboBox;
	private JTextField nameTF;

	private BGSimulation simulation;

	/**
	 * Constructor
	 */
	public MyAppUI() {
		customizeGUI();
		showUI(); // Execute a UI Thread startup

		simulation = new BGSimulation();
		simulation.addObserver(canvas); // Inform canvas of updates
	}

	/**
	 * Implement miscellaneous UI adjustments
	 */
	private void customizeGUI() {
		frame.setSize(600, 600); // Width, height
		frame.setTitle("MyAppUI_LeiZhang");
	}

	/**
	 * Get the custom canvas
	 * @return
	 */
	private JPanel getCanvasPanel() {
		if (canvas == null)
			canvas = new MyCanvas(); // Only build this once

		return canvas;
	}


	/**
	 * Build a main panel
	 * @return a JPanel with content
	 */
	public JPanel getMainPanel() {
		if (mainPanel != null)
			return mainPanel; // Only build the panel once

		mainPanel = new JPanel();
		mainPanel.setBackground(Color.GRAY);

		// Create labels
		label1 = new JLabel("Rule:");
		label2 = new JLabel("Select a BG rule first. Then press 'Start' to begin.");
		label2.setForeground(Color.WHITE);
		label2.setHorizontalAlignment(JLabel.CENTER); // Set center alignment

		// Create a panel to contain the comboBox and the buttons
		JPanel subPanel = new JPanel();
		subPanel.setLayout(new FlowLayout());
		subPanel.setBackground(Color.GRAY);

		// Create a comboBox
		String[] rules = new String[] { "", "Rule1: angle=120\u00B0", 
				"Rule2: angle=30\u00B0", "Rule3: angle=60\u00B0" };
		comboBox = new JComboBox<String>(rules);

		// Initialize the BGSimulation by the selection
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (comboBox.getSelectedItem().equals("Rule1: angle=120\u00B0")) {
					label2.setText("Rule1 selected.");
					simulation.setRule(new BGRule1());
				} else if (comboBox.getSelectedItem().equals("Rule2: angle=30\u00B0")) {
					label2.setText("Rule2 selected.");
					simulation.setRule(new BGRule2());
				} else if (comboBox.getSelectedItem().equals("Rule3: angle=60\u00B0")) {
					label2.setText("Rule3 selected.");
					simulation.setRule(new BGRule3());
				} else {
					label2.setText("Warning: must select a rule.");
				}
			}
		});

		// Create the buttons
		startBtn = new JButton("Start");
		pauseBtn = new JButton("Pause");
		stopBtn = new JButton("Stop");
		resetBtn = new JButton("Reset");

		startBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n>>>Start pressed - Anonymous inner callback.");
				label2.setText("Start pressed.");
				startBtn.setBackground(Color.DARK_GRAY); // Change background color to dark to prevent further click
				simulation.startSim();
			}
		});

		pauseBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n>>>Pause pressed - Anonymous inner callback");
				label2.setText("Pause pressed.");
				simulation.pauseSim();
			}
		});

		stopBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n>>>Stop pressed - Anonymous inner callback");
				label2.setText("Stop pressed.");
				simulation.stopSim();
			}
		});

		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("\n>>>Reset pressed - Anonymous inner callback.");
				label2.setText("Simulation reset.");
				startBtn.setBackground(new JButton().getBackground()); // Restore the background color of start button
				simulation.resetSim();
				canvas.setGen(null); // Clear canvas
				canvas.repaint();
			}
		});

		mainPanel.setLayout(new BorderLayout()); // Widgets will flow from left to right
		// Add components to the panel
		mainPanel.add(label2, BorderLayout.SOUTH);
		subPanel.add(label1);
		subPanel.add(comboBox);
		subPanel.add(startBtn);
		subPanel.add(pauseBtn);
		subPanel.add(stopBtn);
		subPanel.add(resetBtn);
		mainPanel.add(subPanel, BorderLayout.CENTER);

		/*nameTF = new JTextField();

		DesignGridLayout pLayout = new DesignGridLayout(mainPanel);
		pLayout.row().grid(new JLabel("Rule:")).add(comboBox);
		pLayout.row().grid(new JLabel("Name:")).add(nameTF);
		pLayout.emptyRow();
		pLayout.row().center().add(startBtn, pauseBtn, stopBtn, resetBtn);
		pLayout.row().center().add(label);*/

		return mainPanel;
	}


	/**
	 * Main() here
	 */
	public static void main(String args[]) {
		MyAppUI myApp = new MyAppUI();
		System.out.println("\n>>>MyAppUI is exiting!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		if (e.getActionCommand().equalsIgnoreCase("Start")) {
			System.out.println("**Start pressed**");
			simulation.startSim(); // Start the simulation
		}
		else if (e.getActionCommand().equalsIgnoreCase("Stop")) {
			System.out.println("**Stop pressed**");
			simulation.stopSim(); // Stop the simulation
		}
		else if (e.getActionCommand().equalsIgnoreCase("Pause")) {
			System.out.println("**Pause pressed**");
			simulation.pauseSim(); // Pause the simulation
		}*/
	}

	@Override
	public JPanel getNorthPanel() {
		return getMainPanel();
	}

	@Override
	public JPanel getCenterPanel() {
		return getCanvasPanel();
	}
}
