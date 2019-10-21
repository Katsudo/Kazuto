package com.chiefclouds.simplejdbcapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chiefclouds.simplejdbcapp.dao.IStudentDao;
import com.chiefclouds.simplejdbcapp.dao.impl.StudentDaoImpl;
import com.chiefclouds.simplejdbcapp.entity.Student;
import com.chiefclouds.simplejdbcapp.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentDao studentDao;

	@Override
	public int addStudent(Student student) {
		//search id and judge whether to add
		try {
			Student result = studentDao.findStudentByStudentNo(student.getStudentNo());
			if(result==null) {
				return studentDao.addStudent(student);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	@Override
	public List<Student> findAllStudents() {
		//find all
		try {
			return studentDao.findAllStudents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;	
	}

	@Override
	public Student findStudentById(int id) {
		//find student by id
		try {
			return studentDao.findStudentById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateClassNoById(int id, int classNo) {
		//search student by id and change the classNo
		try {
			return studentDao.updateClassNoById(id, classNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteStudentById(int id) {
		//delete a student's info from table
		try {
			return studentDao.deleteStudentById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	

}
