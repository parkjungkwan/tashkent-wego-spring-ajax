package com.wego.web.lambda;

import java.util.ArrayList;

public class LambdaList {
	public static void main(String[] args) {
		ArrayList <Integer> list = new ArrayList<>();
		for(int i=0;i <10;i++)
			list.add(i);
		list.forEach(i->System.out.print(i+",\t"));
		System.out.println();
		list.removeIf(x -> x % 2 ==0);
		list.replaceAll(i -> i * 10);
		list.forEach(i->System.out.print(i+",\t"));
		
	}

}
