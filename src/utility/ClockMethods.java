package utility;

public class ClockMethods {
	
	/** 
	 * Method returns a string representation of seconds in minutes:seconds format
	 * @param seconds
	 * @return
	 */
	public static String getDurationAsString(int seconds) {
		
		int minutes = seconds / 60;
		int secs = seconds % 60;
		
		String minString = "";
		if (minutes < 10) minString = "0" + minutes;
		else minString = minutes + "";
		
		String secString = "";
		if (secs < 10) secString = "0" + secs;
		else secString = secs + "";
			
		return minString + ":" + secString;
	}

}
