package com.wego.web.pxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import org.springframework.stereotype.Component;

@Component
public class Proxy {
	public int integer(String param) {
		Function<String, Integer> f = s -> Integer.parseInt(s);
		return f.apply(param);
	}
	public int random(int a, int b) {
		BiFunction<Integer, Integer, Integer> f =(t,u)->(int)(Math.random()*(u-t))+t;
		return f.apply(a, b);
		
	}
	
}


