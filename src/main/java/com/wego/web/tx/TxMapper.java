package com.wego.web.tx;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wego.web.brd.Community;
import com.wego.web.usr.User;

@Repository
public interface TxMapper {
	@Insert(" INSERT INTO USER (UID,PWD,UNAME,BIRTH,GENDER,TEL,PETTYPE) VALUES (" + 
			"    #{uid}, #{pwd},#{uname},#{birth}, #{gender},#{tel},#{pettype})")
	public void insertUser(User u);
	
	@Insert("insert into community ( rating,img,uid, comments, msg, boardtype, title, content) values(\n" + 
			"        #{rating},#{img},#{uid},#{comments},#{msg},#{boardtype},#{title},#{content}\n" + 
			"    )")
	public void insertArticles(Community c);
	

}
