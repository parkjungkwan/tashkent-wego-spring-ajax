package com.wego.web.adm;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.cmm.IConsumer;
import com.wego.web.cmm.IFunction;
import com.wego.web.ctx.CollectionConfig;
import com.wego.web.ctx.CollectionsBean;
import com.wego.web.usr.User;
import com.wego.web.usr.UserCtrl;
import com.wego.web.usr.UserMapper;
import com.wego.web.utl.Printer;


@RestController
@RequestMapping("/admins")
public class AdminCtrl {
	private static final Logger logger = LoggerFactory.getLogger(UserCtrl.class);
	//@Resource HashMap<String, String>stringMap;
	//@Resource HashMap<String, Admin>adminMap;
	@Autowired Admin admin;
	@Autowired Printer p;
	@Autowired AdminMapper adminMapper;
	
	
	
	@PostMapping("/")
	public Map<?,?> register(@RequestBody Admin param) {
		HashMap<String, String>stringMap = new HashMap<>();
		p.accept(" join 들어옴 : "+param.toString());
		IConsumer<User> c = null;
		stringMap.clear();
		stringMap.put("msg", "SUCCESS");
		return stringMap;
	}
	private Object tx(HashMap<String, Object> param) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CollectionConfig.class);
		CollectionsBean collectionsBean = context.getBean(CollectionsBean.class);
		/* final Function<HashMap<String, Object>,Admin> f = t-> adminMapper.selectAdmin(adminMap);
		if((f.apply(param)!= null)) {
			
		}else {
			
		}
		String result = (f.apply(param)!= null) ? "SUCCESS" : "FAIL";*/
		return null;
	}
	
	@PostMapping("/{eid}")
	public Map<?,?> access(@PathVariable String eid, @RequestBody HashMap<String, Object> param) {
		HashMap<String, Admin>adminMap = new HashMap<>();
		adminMap.clear();
		/*adminMap.put("admin", param);
		adminMap.put("eid", "EID");
		adminMap.put("pwd", "PWD");
		adminMap.clear();
		adminMap.put("msg", tx(param).toString());*/
		return adminMap;
	}
	
	@GetMapping("/{aid}")
	public Map<?,?> searchUserById(@PathVariable String param) {
		HashMap<String, Admin>adminMap = new HashMap<>();
		adminMap.clear();
		/*adminMap.put("eid", param);
		adminMap.clear();
		adminMap.put("msg", "");*/
		return null;
	}
	
	@PutMapping("/{aid}")
	public Map<?,?> updateUser(@PathVariable String uid, @RequestBody Admin param) {
		HashMap<String, Admin>adminMap = new HashMap<>();
		IConsumer<Admin> c = o->adminMapper.updateAdmin(param);
		c.accept(param);
		adminMap.clear();
		//adminMap.put("msg", "SUCCESS");
		return adminMap;
	}
	
	@DeleteMapping("/{aid}")
	public Map<?,?> removeUser(@PathVariable String uid, @RequestBody Admin param) {
		HashMap<String, Admin>adminMap = new HashMap<>();
		IConsumer<Admin> c = o->adminMapper.deleteAdmin(param);
		c.accept(param);
		adminMap.clear();
		//adminMap.put("msg", "SUCCESS");
		return adminMap;
	}

}
