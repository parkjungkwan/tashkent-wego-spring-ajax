package com.wego.web.pxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;
@Component @Data @Lazy
public class Box<T> {
	
	private ArrayList<T> list;
	public void add(T item) {
		list = new ArrayList<T>();
		list.add(item);
	}
	public T get(int i) {return list.get(i);}
	public ArrayList<T> getList() {return list;}
	public int size() {return list.size();}
	public String toString() {return list.toString();}

	
}
