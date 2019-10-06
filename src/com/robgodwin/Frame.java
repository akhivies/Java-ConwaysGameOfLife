package com.robgodwin;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.robgodwin.Grid;

public class Frame extends JFrame {

	JFrame frame = new JFrame("Conway's Game of Life");
	JPanel topPanel = new JPanel();
	static JLabel statusLabel = new JLabel("Life is paused");
	JPanel panel = new JPanel();
	JPanel bottomPanel = new JPanel();

	public Frame() {
		frame.add(topPanel, BorderLayout.NORTH);
		frame.add(panel, BorderLayout.CENTER);
		frame.add(bottomPanel, BorderLayout.SOUTH);
		topPanel.add(statusLabel);
		panel.add(new Grid());
		bottomPanel.add(new Running());
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
