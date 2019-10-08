package com.robgodwin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import com.robgodwin.Running;

public class Cell extends JButton {

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

	public boolean isAlive(int y, int x) {
		if (Grid.cell[y][x].getText().equals("*")) {
			return true;
		} else {
			return false;
		}
	}
	
	public int surroundingAliveCount(int y, int x) {
		int count = 0;
		// If not at edge of grid check surrounding cells
		if (y>0 && y<99 && x>0 && x<99) {
			if (Grid.cell[y+1][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x-1].getText().equals("*")) {
				count++;
			}
		// if at top left corner wrap
		} else if (y==0 && x==0) {
			if (Grid.cell[y+1][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][99].getText().equals("*")) {
				count++;
			}
		// if at bottom left corner wrap
		} else if (y==0 && x==99) {
			if (Grid.cell[y+1][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x-1].getText().equals("*")) {
				count++;
			}
			// if at top right corner wrap
		} else if (y==99 && x==0) {
			if (Grid.cell[0][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][99].getText().equals("*")) {
				count++;
			}
		// if at bottom right corner wrap
		} else if (y==99 && x==99) {
			if (Grid.cell[0][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x-1].getText().equals("*")) {
				count++;
			}
		// if on left side wrap
		} else if (y==0) {
			if (Grid.cell[y+1][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[99][x-1].getText().equals("*")) {
				count++;
			}
		// if on right side wrap
		} else if (y==99) {
			if (Grid.cell[0][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[0][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x-1].getText().equals("*")) {
				count++;
			}
		// if on top side wrap
		} else if (x==0) {
			if (Grid.cell[y+1][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][99].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x+1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][99].getText().equals("*")) {
				count++;
			}
		// if on bottom side wrap
		} else if (x==99) {
			if (Grid.cell[y+1][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y+1][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y][x-1].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][0].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x].getText().equals("*")) {
				count++;
			}
			if (Grid.cell[y-1][x-1].getText().equals("*")) {
				count++;
			}
		}
		return count;
	}
}
