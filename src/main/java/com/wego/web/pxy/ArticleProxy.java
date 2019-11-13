package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.brd.Article;
import com.wego.web.brd.ArticleMapper;
import com.wego.web.brd.Community;
import com.wego.web.brd.CommunityMapper;
import com.wego.web.tx.TxMapper;

@Component("eunbi")
public class ArticleProxy {
	@Autowired ArticleMapper articleMapper;
	@Autowired TxMapper txMapper;
	@Autowired Article article;
	@Autowired CrawlingProxy crawler;
	@Autowired Trunk<String> trunk;
	@Autowired Box<String> box;
	

	public String writerUID() {
		List<String> uids = Arrays.asList("01ikor", "056tac", "06jdh7", "0dlrem", "0qs5fw", "0trane", "0v4w3a",
				"0wi326", "0yr71f", "10srly");
		Collections.shuffle(uids);
		String uid = uids.get(0);
		return uid;
	}

	public String comment() {
		List<String> fcontent = Arrays.asList("첫 방문인데", "세번째 방문인데", "여러번 방문인데", "다시 오고싶은", "훌륭한", "다시한번 오고싶은",
				"두번째 방문인데", "자주왔지만 다음엔");
		List<String> comments = Arrays.asList("좋아요", "싫어요", "그냥그래요", "별로에요", "대만족", "친절함",
									"편함", "나쁘지 않아요", "괜찮습니다",
				"매우만족합니다");
		Collections.shuffle(fcontent);
		Collections.shuffle(comments);
		return fcontent.get(0) + comments.get(0);
	}

	public ArrayList<String> content() {
		trunk.put(Arrays.asList("site","srch"), Arrays.asList("직접입력","스톤애견풀빌라"));
		
		
		return crawler.choose(trunk.get()).get();
	}

	public String title() {
		List<String> titles = Arrays.asList("우리 꽁이 너무 귀여워요", "나래랑 콩이랑 자꾸 싸워요 ㅠㅠ", "우리 강아지가 편식해요", "댕댕이 처음 키워봐여!!",
				"사료 추천해주세요~","너무좋아요", "또오고 싶어요", "여기 살고 싶어요", "주변에 알리고 싶어요", "주변에 소개하고 싶어요",
				"다음에 다시 올게요!", "다음엔 또치도 데리고 올게요", "다음엔 둘리도 데리고 올게요", "다음엔 꽁이도 데리고 올게요", "다음엔 콩이도 데리고 올게요",
				"다음엔 나래도 데리고 올게요", "다음엔 방울이도 데리고 올게요", "다음엔 고양이도 데리고 올게요", "다음엔 강아지도 데리고 올게요", "다음엔 구찌도 데리고 올게요");
		Collections.shuffle(titles);
		String title = titles.get(0);
		return title;
	}

	public String msg() {
		List<String> msgs = Arrays.asList("좋아용", "별로에용", "짱이에요", "나이스", "굿", "존좋");
		Collections.shuffle(msgs);
		String msg = msgs.get(0);
		return msg;
	}

	public String rating() {
		List<String> ratings = Arrays.asList("1점", "2점", "3점", "4점", "5점");
		Collections.shuffle(ratings);
		String rating = ratings.get(0);
		return rating;
	}

	private String boardtype() {
		return "커뮤니티";
	}

	public String artseq() {
		return null;
	}

	public String makeImge() {
		return null;
	}



	@Transactional
	public void insertArticles() {
		ArrayList<String> t = content();
		for (int i = 1; i <= 50; i++) {
			Collections.shuffle(t);
			txMapper.insertArticles(new Article(artseq(), makeImge(), writerUID(), comment(), msg(), 
					rating(), boardtype(), t.get(0), title()));

		}
	}
}
