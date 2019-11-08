package com.wego.web.brd;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wego.web.pxy.Proxy;
import com.wego.web.usr.User;

@Repository
public interface ArticleMapper {
	public void insertArticle(Article param);
	public String countArticle();
	public List<Article> selectAll(Proxy pxy);
}
