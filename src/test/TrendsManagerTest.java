package test;

import model.TrendsManager;

public class TrendsManagerTest {
	
	/**
	 * Test class
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TrendsManager.getLatestTrends();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
