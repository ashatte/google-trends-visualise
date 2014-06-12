package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.WordField;

public class DisplayPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WordField wordField;
	
	/**
	 * Inits the bg color and wordField
	 */
	public DisplayPanel() {
		setBackground(Color.white);
		wordField = new WordField();
	}
	
	/**
	 * Calls wordField to update its words
	 */
	public void update() {
		wordField.update();
	}
	
	/**
	 * Calls the wordField to update the trends via the web feed
	 */
	public void updateTrends() {
		wordField.updateTrends();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		wordField.draw(g);
	}

}
