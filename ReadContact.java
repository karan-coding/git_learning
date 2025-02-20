package com.DAO;

import java.util.List;

import com.Modle.BindData;
import com.Modle.EducationModle;
import com.Modle.projectFile;

public interface ReadContact {
	 public List<BindData> readeContact();
	 public List<projectFile> readProjectFileData();
	 public List<EducationModle> readEducation();
}
