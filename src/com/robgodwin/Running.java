package com.robgodwin;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class Running extends JButton {

	public static boolean running = false;

	public Running() {

		setText("Start");
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				new Thread() {
					public void run() {
						if (!running) {
							running = true;
							Frame.statusLabel.setText("Life is running!");
							setText("Pause");
							Cell.setNextGeneration();
						} else {
							running = false;
							Frame.statusLabel.setText("Life is paused! Click a cell to bring it to life.");
							setText("Start");
						}
					}
				}.start();
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
