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
						setText("*");
					} else {
						setBackground(Color.LIGHT_GRAY);
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
	
	private boolean isAlive() {
		for (int y = 0; y < 100; y++) {
			for (int x = 0; x < 100; x++) {
				if (Grid.cell[y][x].getText().equals("*")) {
					return true;
				}
			}
		}
		return false;
	}

}
