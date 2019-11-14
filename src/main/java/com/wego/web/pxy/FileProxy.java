package com.wego.web.pxy;

import java.io.File;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.wego.web.enums.Path;
@Component("filemgr")
public class FileProxy extends Proxy{
	public void fileupload(MultipartFile[] uploadFile) {
		String uploadFolder = Path.UPLOAD_PATH.toString();
		for(MultipartFile m : uploadFile) {
			String fname = m.getOriginalFilename();
			fname = fname.substring(fname.lastIndexOf("\\")+1);
			File savedFile = new File(uploadFolder, fname);
			try {
				m.transferTo(savedFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
