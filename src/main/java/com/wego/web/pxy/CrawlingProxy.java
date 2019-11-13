package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
		switch(string(paramMap.get("srch"))) {
		case "스톤애견풀빌라":
			box = crawling(Path.CRAWLING_TARGET.toString()+"1");
			break;
			
		default : 
			crawling("http://" + paramMap.get("site") + "/");
			break;
		}
		return box;
	}
	private Box<String> crawling(String url) {
		printer.accept("넘어온 URL \n" + url);
		box.clear();
		
		try {
			// "https://music.bugs.co.kr/recomreview?&order=listorder&page=2"
			Document rawData = Jsoup.connect(url).timeout(10*1000).get();
			  Elements artist = rawData.select("div[class=review_txt]"); 
			  
			  for(Element e : artist) {
				  box.add(e.text()+"\n ***************** \n");
			  }
			 
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return box;
		
	}
}
