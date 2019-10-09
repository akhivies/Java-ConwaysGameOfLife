package com.robgodwin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import com.robgodwin.Running;

public class Cell extends JButton {

	public static int generationCount = 1;

	public Cell() {

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!Running.isRunning()) {
					if (getText().equals(" ")) {
						setBackground(Color.BLACK);
						setBorder(new LineBorder(Color.BLACK));
						setText("*");
					} else {
						setBackground(Color.LIGHT_GRAY);
						setBorder(new LineBorder(Color.GRAY));
						setText(" ");
					}
				}
			}

		});

		setBackground(Color.LIGHT_GRAY);
		setBorder(new LineBorder(Color.GRAY));
		setText(" ");
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(8, 8);
	}

	public static void setNextGeneration() {
		while (Running.isRunning()) {
			for (int y = 0; y < 100; y++) {
				for (int x = 0; x < 100; x++) {
					int aliveNeighbors = surroundingAliveCount(y, x);
					if (Grid.cell[y][x].isAlive(y, x)) {
						// If less than two neighbors alive cell dies due to under-population
						if (aliveNeighbors < 2) {
							Grid.nextGeneration[y][x] = " ";
							// If two or three neighbors cell lives on to next generation
						} else if (aliveNeighbors >= 2 && aliveNeighbors <= 3) {
							Grid.nextGeneration[y][x] = "*";
							// If more than three neighbors cell dies due to over-population
						} else {
							Grid.nextGeneration[y][x] = " ";
						}
					} else if (!Grid.cell[y][x].isAlive(y, x)) {
						// If cell is dead and has 3 alive neighbors, cell is born
						if (aliveNeighbors == 3) {
							Grid.nextGeneration[y][x] = "*";
						}
					}
				}
			}
		tick();
		}
	}

	public static void tick() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int y = 0; y < 100; y++) {
			for (int x = 0; x < 100; x++) {
				if (Grid.nextGeneration[y][x] == "*") {
					Grid.cell[y][x].setText("*");
					Grid.cell[y][x].setBackground(Color.BLACK);
					Grid.cell[y][x].setBorder(new LineBorder(Color.BLACK));
				} else {
					Grid.cell[y][x].setText(" ");
					Grid.cell[y][x].setBackground(Color.LIGHT_GRAY);
					Grid.cell[y][x].setBorder(new LineBorder(Color.GRAY));
				}
			}
		}
	}

	public boolean isAlive(int y, int x) {
		if (Grid.cell[y][x].getText().equals("*")) {
			return true;
		} else {
			return false;
		}
	}

	public static int surroundingAliveCount(int y, int x) {
		int count = 0;
		// If not at edge of grid check surrounding cells
		if (y > 0 && y < 99 && x > 0 && x < 99) {
			if (Grid.cell[y + 1][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x - 1].getText().equals("*")) {
				count++;
			}
			// if at top left corner wrap
		} else if (y == 0 && x == 0) {
			if (Grid.cell[y + 1][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][99].getText().equals("*")) {
				count++;
			}
			// if at bottom left corner wrap
		} else if (y == 0 && x == 99) {
			if (Grid.cell[y + 1][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x - 1].getText().equals("*")) {
				count++;
			}
			// if at top right corner wrap
		} else if (y == 99 && x == 0) {
			if (Grid.cell[0][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][99].getText().equals("*")) {
				count++;
			}
			// if at bottom right corner wrap
		} else if (y == 99 && x == 99) {
			if (Grid.cell[0][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x - 1].getText().equals("*")) {
				count++;
			}
			// if on left side wrap
		} else if (y == 0) {
			if (Grid.cell[y + 1][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x - 1].getText().equals("*")) {
				count++;
			}
			// if on right side wrap
		} else if (y == 99) {
			if (Grid.cell[0][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x - 1].getText().equals("*")) {
				count++;
			}
			// if on top side wrap
		} else if (x == 0) {
			if (Grid.cell[y + 1][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x + 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][99].getText().equals("*")) {
				count++;
			}
			// if on bottom side wrap
		} else if (x == 99) {
			if (Grid.cell[y + 1][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y + 1][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x - 1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y - 1][x - 1].getText().equals("*")) {
				count++;
			}
		}
		return count;
	}
}
