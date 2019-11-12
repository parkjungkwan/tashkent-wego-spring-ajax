package com.wego.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	//@Autowired List<String> txServicelist;
	
	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		List<String> txServicelist = new ArrayList<>();
		txServicelist.clear();
		txServicelist = (List<String>) crawler.crawl(paramMap);
		return txServicelist;
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
	
}
