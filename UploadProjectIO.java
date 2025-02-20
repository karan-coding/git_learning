package com.fileIO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.http.Part;

public class UploadProjectIO {
	private String result;
	public String write(Part part, String formateFileName , String realPath) {
		// TODO Auto-generated method stub
		
		
		try {
			InputStream inputStream = part.getInputStream();
			byte[] b = inputStream.readAllBytes();
			System.out.println(formateFileName);
			System.out.println(realPath);
			//String path="E:\\Servlet\\webprj2\\src\\main\\webapp\\myProject"+File.separator+formateFileName;
			String path=realPath+File.separator+formateFileName;
			System.out.println(path);
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(b);
			return "UPLOADED";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "FAILED";
		}
		
	}
	
	 

}
