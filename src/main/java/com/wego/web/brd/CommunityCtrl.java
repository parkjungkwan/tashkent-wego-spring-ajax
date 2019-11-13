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
@RequestMapping("/community")
public class CommunityCtrl {
	private static final Logger logger = LoggerFactory.getLogger(CommunityCtrl.class);
	@Autowired Community article;
	@Autowired Printer printer;
	@Autowired CommunityMapper articleMapper;
	@Autowired Box<Community>box;
	@Qualifier PageProxy pager;
	@Qualifier Trunk<Object> trunk;
	
	@PostMapping("/")
	public Map<?,?> write(@RequestBody Community param){
		param.setBoardType("게시판");
		IConsumer<Community> c = t-> articleMapper.insertArticle(param);
		c.accept(param);
		ISupplier<String> s =()-> articleMapper.countArticle();
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
		ISupplier<List<Community>> s =()-> articleMapper.selectAll(pager);
		printer.accept("해당 페이지 글목록 \n"+s.get());
		int ran = pager.random(3, 11);
		System.out.println("랜덤 수 출력 : "+ ran);
		trunk.put(Arrays.asList("articles","pxy"),
				Arrays.asList(s.get(),pager));
		return trunk.get();
	}
	
	@GetMapping("/count")
	public Map<?,?> count(){
		ISupplier<String> s =()-> articleMapper.countArticle();
		printer.accept("카운팅 : "+s.get());
		trunk.put(Arrays.asList("count"),Arrays.asList(s.get()));
		return trunk.get();
	}
	
	@GetMapping("/{artseq}")
	public Community read(@PathVariable String artseq, @RequestBody  Community param) {
		return null;
	}
	@PutMapping("/{artseq}")
	public Community update(@PathVariable String artseq, @RequestBody Community param) {
		return null;
	}
	@DeleteMapping("/{artseq}")
	public Map<?,?> delete(@PathVariable String artseq, @RequestBody Community param){
		return null;
	}
	
	@GetMapping("/fileupload")
	public void fileUpload() {
		
	}
	@GetMapping("/create/table")
	public Map<?,?> createUser(){
		HashMap<String, String> paramMap = new HashMap<>();
		paramMap.put("CREATE_COMMUNITY", SQL.CREATE_COMMUNITY.toString());
		printer.accept("테이블 생성 쿼리 : \n"+paramMap.get("CREATE_COMMUNITY"));
		IConsumer<HashMap<String, String>> c = o->articleMapper.createCommunity(o);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
	}

}
