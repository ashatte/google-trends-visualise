package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Word {

	private String word;
	private int fontSize = 12;
	private int count = 0;
	int x, y, xSpeed, ySpeed;
	int wordWidth;

	int speedCoolDown;

	private static Random random = new Random();

	public Word(String word) {
		this.word = word;
		this.count = 1;

		x = random.nextInt(200);
		y = random.nextInt(200);
		xSpeed = random.nextInt(2) - random.nextInt(1);
		ySpeed = random.nextInt(2) - random.nextInt(1);

		speedCoolDown = random.nextInt(900);
	}

	/**
	 * 
	 * @return Returns the word as a string value
	 */
	public String getWord() {
		return word;
	}

	/**
	 * Increases the count
	 */
	public void increaseCount() {
		count += 5;
	}

	/**
	 * Future feature will set a random font for each word
	 */
	public void setRandomFont() {
		// set a random font here
		// set a random size
		// set a random color
	}
	
	/**
	 * 
	 * @return The bounds of the rectangle surrounding the word
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y - (fontSize + (count - 2)), wordWidth, fontSize + count);
	}
	
	/**
	 * Reverse the current direction of movement
	 */
	public void reverseDirection() {
		xSpeed *= -1;
		ySpeed *= -1;
	}

	/**
	 * Updates the words and lowers counters
	 */
	public void update() {
		if (x + xSpeed >= 500 - wordWidth)
			xSpeed *= -1;
		if (x + xSpeed < 0)
			xSpeed *= -1;
		if (y + ySpeed > 480)
			ySpeed *= -1;
		if (y + ySpeed < 0)
			ySpeed *= -1;

		speedCoolDown--;
		if (speedCoolDown <= 0) {
			xSpeed = random.nextInt(2) - random.nextInt(1);
			ySpeed = random.nextInt(2) - random.nextInt(1);
			speedCoolDown = random.nextInt(900);
		}

		showMeCountDown--;
		if (showMeCountDown <= 0) {
			showMe = random.nextBoolean();
			showMeCountDown = random.nextInt(1000);
		}
	}

	/** hide words at random to avoid overloading GUI (aesthetic choice) **/
	boolean showMe = true;
	int showMeCountDown = 100;

	/**
	 * Draw the words in terms of position, size, and color
	 * @param g
	 */
	public void draw(Graphics g) {
		if (showMe) {
			int fontStyle = count >= 10 ? Font.BOLD : Font.PLAIN;
			Color c = count >= 10 ? Color.RED : Color.ORANGE;
			if (count <= 5)
				c = Color.BLUE;

			g.setFont(new Font("TimesRoman", fontStyle, fontSize + count));
			if (xSpeed == 0 && ySpeed == 0)
				g.setColor(c);
			else
				g.setColor(Color.GRAY);
			g.drawString(word, x += xSpeed, y += ySpeed);
			wordWidth = g.getFontMetrics().stringWidth(word);
		}
	}
}