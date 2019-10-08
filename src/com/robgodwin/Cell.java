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
		return count;
	}
}
