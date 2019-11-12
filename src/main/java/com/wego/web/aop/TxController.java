package com.wego.web.aop;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.pxy.Box;
import com.wego.web.pxy.Trunk;
import com.wego.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
	@Autowired Printer printer;
	@Autowired TxService txService;
	@Autowired Trunk<Object> trunk;
	
	@GetMapping("/crawling/{site}/{srch}")
	public void bringUrl(@PathVariable String site,
			@PathVariable String srch) {
		printer.accept(site +", srch "+srch);
		trunk.put(Arrays.asList("site","srch"),
				Arrays.asList(site, srch) );
		txService.crawling(trunk.get());
	}
	@GetMapping("/register/users")
	public Map<?,?> registerUsers() {
		
		int userCount = txService.registerUsers();
		printer.accept("서비스 카운팅: "+ userCount);
		trunk.put(Arrays.asList("userCount"), Arrays.asList(userCount));
		return trunk.get();
	}
}
