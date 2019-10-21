package com.chiefclouds.simplejdbcapp.service;

import java.util.List;

import com.chiefclouds.simplejdbcapp.entity.Student;

public interface IStudentService {
	//add
	public int addStudent(Student student);
	
	//find
	public List<Student> findAllStudents();
	
	//find one by id
	public Student findStudentById(int id);
	
	//search student by id and change the classNo
	public int updateClassNoById(int id, int classNo);
	
	//delete a student's info from table
	public int deleteStudentById(int id);

}
