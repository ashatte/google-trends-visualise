package model;

import java.awt.Color;
import java.awt.Graphics;

public class WordField {
	
	// Stores a list of all words from the web feeds
	private WordList wordList;
	
	public WordField() {
		wordList = new WordList();
	}
	
	/**
	 * Update each word's position and movement
	 */
	public void update() {
		for (Word w : wordList.getWordList()) {
			w.update();
		}
		
		// check collisions (with other words and also walls)
		for (int i = 0; i < wordList.getWordList().size(); i++) {
			for (int j = 0; j < wordList.getWordList().size(); j++) {
				if (wordList.getWordList().get(i) != wordList.getWordList().get(j)) {
					if (wordList.getWordList().get(i).getBounds().intersects(wordList.getWordList().get(j).getBounds())) {
						wordList.getWordList().get(i).reverseDirection();
						wordList.getWordList().get(j).reverseDirection();
					}
				}
			}
		}
	}
	
	/**
	 * Calls the Jsoup methods to get new words from web feed
	 */
	public void updateTrends() {
		wordList.updateWordList();
	}
	
	/**
	 * Need to check if wordList is null first, incase delay occurs in networking
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.black);
		if (wordList.getWordList() == null) return;
		for (Word word : wordList.getWordList()) {
			word.draw(g);
		}
	}

}
