package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.wego.web.utl.Printer;

public class CrawlingProxy extends Proxy{
	@Autowired Printer printer;
	public List<?> crawl(Map<?, ?> paramMap) {
		String url = "http://" + paramMap.get("site") + "/";
		printer.accept("넘어온 URL \n" + url);
		List<String> proxyList = new ArrayList<>();
		proxyList.clear();
		try {
			Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).execute();
			Document document = response.parse();
			String text = document.html();
			// String text = document.text();
			printer.accept("크롤링한 텍스트 \n" + text);
			proxyList.add(text);

		} catch (Exception e2) {
			e2.printStackTrace();
		}

		return proxyList;
	}
}
