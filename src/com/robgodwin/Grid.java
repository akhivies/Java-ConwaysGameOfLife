package com.robgodwin;

import java.awt.GridLayout;
import javax.swing.JButton;
import com.robgodwin.Cell;

public class Grid extends JButton {

	public Grid() {
		setLayout(new GridLayout(50, 50, 0, 0));
		addButtons();
	}

	public static Cell[][] cell = new Cell[50][50];
	public static String[][] nextGeneration = new String[50][50];

	private void addButtons() {
		for (int y = 0; y < 50; y++) {
			for (int x = 0; x < 50; x++) {
				add(cell[y][x] = new Cell());
			}
		}
	}
}
