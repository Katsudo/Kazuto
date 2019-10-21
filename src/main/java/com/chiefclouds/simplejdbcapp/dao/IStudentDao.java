package com.chiefclouds.simplejdbcapp.dao;

import java.util.List;



import com.chiefclouds.simplejdbcapp.entity.Student;


public interface IStudentDao {
	
	//search by id
	public Student findStudentByStudentNo(int studentNo) throws Exception;
	//add s student to table
	public int addStudent(Student student) throws Exception;
	//get all students from table
	public List<Student> findAllStudents() throws Exception;
	//find a student by id
	public Student findStudentById(int id) throws Exception;
	//search student by id and change the classNo
	public int updateClassNoById(int id, int classNo) throws Exception;
	//delete a student's info from table
	public int deleteStudentById(int id) throws Exception;
}
