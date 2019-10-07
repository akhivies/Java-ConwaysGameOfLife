package com.robgodwin;

import java.awt.GridLayout;
import javax.swing.JButton;
import com.robgodwin.Cell;

public class Grid extends JButton {

	public Grid() {
		setLayout(new GridLayout(100, 100, 0, 0));
		addButtons();
	}

	public static Cell[][] cell = new Cell[100][100];

	private void addButtons() {
		for (int y = 0; y < 100; y++) {
			for (int x = 0; x < 100; x++) {
				add(cell[y][x] = new Cell());

			}
		}
	}
}
