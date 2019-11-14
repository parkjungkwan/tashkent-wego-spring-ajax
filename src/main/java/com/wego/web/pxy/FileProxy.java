package com.wego.web.pxy;

import java.io.File;
import java.util.UUID;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.wego.web.enums.Path;
@Component("filemgr")
public class FileProxy extends Proxy{
	
	public void fileupload(MultipartFile[] uploadFile) {
		String uploadFolder = Path.UPLOAD_PATH.toString();
		File uploadPath = makeDir(uploadFolder, getFolder());
		
		if(uploadPath.exists() == false) {
			uploadPath.mkdirs();
		}
		final String s = getFolder();
		for(MultipartFile m : uploadFile) {
			String fname = m.getOriginalFilename();
			String extension = fname.substring(fname.lastIndexOf(".")+1);
			fname = fname.substring(fname.lastIndexOf("\\")+1, fname.lastIndexOf("."));
			File savedFile = makeFile(uploadPath, fname+"-"+UUID.randomUUID().toString()+"."+extension);
			try {
				m.transferTo(savedFile);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	
	public String getFolder() {
		return currentDate().replace("-", File.separator);
	}
}
