package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class Trunk<T> {
	private HashMap<String, T> map;
	public void put(List<String> x, List<T> y) {
		map = new HashMap<>();
		for (int i = 0; i < x.size(); i++) {
			map.put(x.get(i), y.get(i));
		}
		map.forEach((k,v)-> System.out.print(String.format("%s : %s", k, v)));
	}
	
	public T get(String k) {
		Function<String, T> f = p -> map.get(p);
		return f.apply(k);
	}
	public HashMap<String, T> get() {return map;}
	public int size() {return map.size();}
}
