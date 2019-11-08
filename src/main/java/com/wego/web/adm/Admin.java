package com.wego.web.adm;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Lazy @Data
@Component 
@AllArgsConstructor
@NoArgsConstructor
public class Admin{
	
	private String eid,pwd,eName,job,mgr,hireDate,sal,comm,deptNo;

}
