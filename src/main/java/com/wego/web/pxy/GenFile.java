package com.wego.web.pxy;

import java.io.File;
import java.util.HashMap;
import java.util.function.BiFunction;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data 
@Component("gfile")
public class GenFile<T> {
	
	private File file;

	public File makeFile(T t1, String t2) {
		HashMap<String, T> o = new HashMap<>();
		o.put("T", t1);
		
		if(o.get("T") instanceof String) {
			file = new File((String)o.get("T"),t2);
		}else  if(o.get("T") instanceof File){
			System.out.println(">>> "+(File)o.get("T"));
			file = new File((File)o.get("T"),t2);
		}
		return file;
	}
	/*
	 File uploadPath = new GenFile<String>().makeFile(uploadFolder, getFolder());
		System.out.println("파일경로 1: "+uploadPath.getPath());
	 File savedFile = new GenFile<File>().makeFile(uploadPath, "");
	 	System.out.println("파일경로 1: "+savedFile.getPath());
	 * */

}
