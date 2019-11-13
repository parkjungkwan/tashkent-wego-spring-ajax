package com.wego.web.brd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IConsumer;
import com.wego.web.cmm.ISupplier;
import com.wego.web.enums.SQL;
import com.wego.web.pxy.PageProxy;
import com.wego.web.pxy.Trunk;
import com.wego.web.pxy.Box;
import com.wego.web.utl.Printer;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	@Autowired Community article;
	@Autowired Printer printer;
	@Autowired ArticleMapper articleMapper;
	@Autowired Box<Community>box;
	@Autowired PageProxy pager;
	@Autowired Trunk<Object> trunk;
	
	@PostMapping("/")
	public Map<?,?> write(@RequestBody Article param){
		//param.setBoardType("게시판");
		IConsumer<Article> c = t-> articleMapper.insertArticle(param);
		c.accept(param);
		ISupplier<String> s =()-> articleMapper.countArticles()+"";
		trunk.put(Arrays.asList("msg", "count"),
				Arrays.asList("SUCCESS",s.get()));
		return trunk.get();
	}
	@GetMapping("/page/{pageNo}/size/{pageSize}")
	public Map<?,?> list(@PathVariable String pageNo,
			@PathVariable String pageSize){
		System.out.println("넘어온 페이지 넘버: "+pageNo);
		pager.setPageNum(pager.integer(pageNo));
		pager.setPageSize(pager.integer(pageSize));
		pager.paging();
		box.clear();
		ISupplier<List<Article>> s =()-> articleMapper.selectAll(pager);
		printer.accept("해당 페이지 글목록 \n"+s.get());
		int ran = pager.random(3, 11);
		System.out.println("랜덤 수 출력 : "+ ran);
		trunk.put(Arrays.asList("articles","pxy"),
				Arrays.asList(s.get(),pager));
		return trunk.get();
	}
	
	@GetMapping("/count")
	public Map<?,?> count(){
		ISupplier<String> s =()-> articleMapper.countArticles()+"";
		printer.accept("카운팅 : "+s.get());
		trunk.put(Arrays.asList("count"),Arrays.asList(s.get()));
		return trunk.get();
	}
	
	@GetMapping("/fileupload")
	public void fileupload() {
		
	}
	
	

}
