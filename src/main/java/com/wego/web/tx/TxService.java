package com.wego.web.tx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.brd.ArticleMapper;
import com.wego.web.brd.CommunityMapper;
import com.wego.web.pxy.ArticleProxy;
import com.wego.web.pxy.Box;
import com.wego.web.pxy.CommunityProxy;
import com.wego.web.pxy.CrawlingProxy;
import com.wego.web.pxy.PageProxy;
import com.wego.web.pxy.Proxy;
import com.wego.web.pxy.UserProxy;
import com.wego.web.usr.User;
import com.wego.web.usr.UserMapper;


@Service
public class TxService {
	@Autowired TxMapper txMapper;
	@Autowired UserMapper userMapper;
	@Autowired CrawlingProxy crawler;
	@Autowired UserProxy manager;
	@Autowired CommunityProxy kjchoi;
	@Autowired ArticleProxy eunbi;
	@Autowired CommunityMapper commnunityMapper;
	@Autowired ArticleMapper articleMapper;
	@Autowired Box<String> box;
	
	public Box<String> crawling(Map<?,?> paramMap){
		return crawler.choose(paramMap);
	}
	@Transactional
	public int registerUsers(){
		manager.insertUsers();
		return userMapper.countUsers();
	}
	public int trucateUsers() {
		manager.truncateUsers();
		return userMapper.countUsers();
	}
	public int writeCommunities() {
		kjchoi.insertCommunity();
		return commnunityMapper.countCommuities();
	}
	public String writeArticles() {
		eunbi.insertArticles();
		return articleMapper.countArticles();
	}
	
}
