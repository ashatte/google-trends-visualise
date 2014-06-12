package model;

import java.util.ArrayList;

public class WordList {

	private ArrayList<Word> wordList;

	/*
	 * Constructor 
	 */
	public WordList() {
		wordList = new ArrayList<Word>();

		try {
			for (String s : TrendsManager.getLatestTrends()) {
				addWord(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Add a word to the ArrayList
	 * Checks for duplicates and increases count if necessary
	 */
	public void addWord(String word) {
		for (Word w : wordList) {
			if (w.getWord().equalsIgnoreCase(word)) {
				w.increaseCount();
				return;
			}
		}
		wordList.add(new Word(word));
	}

	/*
	 * Get the latest words every half hour from Google Trends
	 */
	public void updateWordList() {
		wordList.clear();
		try {
			for (String s : TrendsManager.getLatestTrends()) {
				wordList.add(new Word(s));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Return the ArrayList of Words
	 */
	public ArrayList<Word> getWordList() {
		return wordList;
	}

}
