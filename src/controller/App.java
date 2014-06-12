package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import javax.swing.Timer;

import utility.ClockMethods;
import view.DisplayPanel;
import view.MainFrame;

public class App {
	
	private MainFrame mainFrame;
	private DisplayPanel displayPanel;

	/**
	 * Constructor for application, inits the window and starts all the timers
	 */
	public App() {
		mainFrame = new MainFrame();
		
		displayPanel = new DisplayPanel();
		
		mainFrame.add(displayPanel);
		
		mainFrame.setVisible(true);
		
		drawLoop.start();
		updateTimer.start();
		timeLoop.start();
	}
	
	/**
	 * Updates the Google trends from the web every 1800000ms (30 minutes).
	 * Note that Google trends feed only updates hourly.
	 */
	private Timer updateTimer = new Timer(1800000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			displayPanel.updateTrends();
		}
	});
	
	/**
	 * Draw timer, updates and repaints the window every 10ms
	 */
	private Timer drawLoop = new Timer(10, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			displayPanel.update();
			displayPanel.repaint();
		}
	});
	
	/**
	 * Timer updates title of window each second to reflect duration of program
	 */
	int i = 1;
	private Timer timeLoop = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			mainFrame.setTitle("Google Trends ~ Total Runtime " + ClockMethods.getDurationAsString(i++));
		}
	});
	
	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new App();
			}
		});
	}
}
