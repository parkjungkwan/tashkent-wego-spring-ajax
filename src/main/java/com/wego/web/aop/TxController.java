package com.wego.web.aop;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wego.web.pxy.ProxyMap;
import com.wego.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/tx")
public class TxController {
	@Autowired Printer printer;
	@Autowired TxService txService;
	@Autowired ProxyMap map;
	
	@GetMapping("/crawling/{site}/{srch}")
	public void bringUrl(@PathVariable String site,
			@PathVariable String srch) {
		printer.accept(site +", srch "+srch);
		map.accept(Arrays.asList("site","srch"),
				Arrays.asList(site, srch) );
		txService.crawling(map.get());
	}
}
