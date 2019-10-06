package com.robgodwin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Running extends JButton{
	
	public static boolean running = false;
	
	public Running() {
		
		setText("Start");
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (!running) {
					running = true;
					Frame.statusLabel.setText("Life is running!");
					setText("Pause");
				} else {
					running = false;
					Frame.statusLabel.setText("Life is paused! Click a cell to bring it to life.");
					setText("Start");
				}
			}

		});
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100, 20);
	}
	
	public static boolean isRunning() {
		return running;
	}

}
