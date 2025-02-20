package com.fileIO;

import java.io.File;

public class DelleteProjectIO {
	private String result;
	public String deleteProjectFile(String filename) {
		try {
			String path="E:\\Servlet\\webprj2\\src\\main\\webapp\\myProject"+File.separator+filename;
			File file = new File(path);
			file.delete();
			result="Deleted";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result="Faild";
		}
		return result;
	}

}
