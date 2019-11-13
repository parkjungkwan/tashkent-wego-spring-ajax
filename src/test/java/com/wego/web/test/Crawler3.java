package com.wego.web.test;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler3 {
	public static void main(String[] args) {
		try {
			Connection.Response response = Jsoup.connect("").method(Connection.Method.GET).execute();
			Document document = response.parse();
			// String text = document.html();
			String text = document.text();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
