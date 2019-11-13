package com.wego.web.pxy;

import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wego.web.enums.Path;
import com.wego.web.utl.Printer;
@Component("crawler")
public class CrawlingProxy extends Proxy{
	@Autowired Printer printer;
	@Autowired Box<String> box;
	public Box<String> choose(Map<?, ?> paramMap) {
		printer.accept("키값 : "+paramMap.get("site"));
		printer.accept("값 : "+paramMap.get("srch"));
		String url = "";
		switch(string(paramMap.get("srch"))) {
		case "스톤애견풀빌라":
			crawling(Path.CRAWLING_TARGET.toString());
			break;
			
		default : 
			crawling("http://" + paramMap.get("site") + "/");
			break;
		}
		return box;
	}
	private void crawling(String url) {
		printer.accept("넘어온 URL \n" + url);
		box.clear();
		
		try {
			Connection.Response response = Jsoup.connect(url).method(Connection.Method.GET).execute();
			Document document = response.parse();
			String text = document.html();
			// String text = document.text();
			printer.accept("===============================");
			printer.accept("크롤링한 텍스트 \n" + text);
			box.add(text);

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}
}
