package model;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

public class TrendsManager {
	
	private static ArrayList<String> latestTrends = new ArrayList<String>(); // ArrayList to store all trends
		
	private static final String TRENDS_USA = "http://www.google.com/trends/hottrends/atom/hourly"; 		// USA trends feed
	private static final String TRENDS_AU = "http://www.google.com.au/trends/hottrends/atom/hourly"; 	// Australia trends feed
	private static final String TRENDS_UK = "http://www.google.co.uk/trends/hottrends/atom/hourly";		// UK trends feed
	private static final String TRENDS_CN = "http://www.google.com.hk/trends/hottrends/atom/hourly";	// China trends feed
	private static final String TRENDS_BR = "http://www.google.com.br/trends/hottrends/atom/hourly";	// Brazil trends feed
	
	// Store them all in a String array
	private static String[] URLS = {TRENDS_USA, TRENDS_AU, TRENDS_UK, TRENDS_CN, TRENDS_BR};
	
	// Connects to each url, downloads trend terms and returns them in an ArrayList
	public static ArrayList<String> getLatestTrends() throws Exception {
		ArrayList<String> trendingStrings = new ArrayList<String>();
		
		for (String url : URLS) {
			String xml = Jsoup.connect(url).get().toString();
			Document doc = Jsoup.parse(xml, "", Parser.xmlParser());
			
			Document doc2 = Jsoup.parse(doc.select("content").first().text());
			Elements trendingItems = doc2.select("li");
			for (Element e : trendingItems) {
				trendingStrings.add(e.text());
			}
		}
		return trendingStrings;
	}
}
