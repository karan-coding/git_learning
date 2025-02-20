package com.fileIO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

public class UploadResumeIO {
	private String result;
	public String write(Part part, String realPath) {
		try {
			InputStream inputStream = part.getInputStream();
			byte[] b = inputStream.readAllBytes();
			FileOutputStream fos = new FileOutputStream(realPath+File.separator+part.getSubmittedFileName());
			fos.write(b);
			fos.close();
			result= "Uploaded";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result= "Faild";
		}
		return result;
		
	}

}
