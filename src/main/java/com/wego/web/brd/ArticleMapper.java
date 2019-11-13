package com.wego.web.brd;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wego.web.pxy.PageProxy;
import com.wego.web.usr.User;

@Repository
public interface ArticleMapper {
	public void insertArticle(Article o);
	public String countArticles();
	public List<Article> selectAll(PageProxy o);
	public void createArticle(HashMap<String, String> o);
}
