package com.asminds.dao;

import java.util.List;


import com.asminds.pojo.Student;
import com.asminds.pojo.UpdatePojo;

public interface Dao {

	
	public void insert(Student s);
	
	public List<Student> search(Student h);
	
	public List<Student> getallStudentpojo() ;
	
	 public void deleteEmployee(Integer id);
	 
	 public List<Student> updateDAO(UpdatePojo s);
	 
		public Boolean updateemployeeDao(Student loo);
}
