package com.chiefclouds.simplejdbcapp.controller;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chiefclouds.simplejdbcapp.entity.Student;
import com.chiefclouds.simplejdbcapp.service.IStudentService;
import com.chiefclouds.simplejdbcapp.service.impl.StudentServiceImpl;
import com.chiefclouds.simplejdbcapp.util.StudentFormatUtil;

@RestController
public class StudentController {
	@Autowired
	private IStudentService studentService;
	
    @RequestMapping(path="/student", method = RequestMethod.GET)
    public String openPage() {
    	return "This is student page, do something";
    }
	
	@RequestMapping(path="/student/add", method = RequestMethod.POST)
	public String addStudent(@RequestParam(value="name", defaultValue="null") String name,
						@RequestParam(value="sex", defaultValue="0") int sex,
						@RequestParam(value="year", defaultValue="2000") int year,
						@RequestParam(value="month", defaultValue="12") int month,
						@RequestParam(value="date", defaultValue="1") int date,
						@RequestParam(value="studentNo", defaultValue="1") int studentNo,
						@RequestParam(value="classNo", defaultValue="1") int classNo) {
		Student student = new Student(0, name, sex, 
				new Timestamp(year-1900, month-1, date, 0, 0, 0, 0), 
				studentNo, classNo);
		int result = studentService.addStudent(student);
		if(result>0) {
			return "add success";
		}
		else
			return "add fail";
	}
	
	@RequestMapping(path="/student/findall", method = RequestMethod.GET)
	public List<Student> findAllStudents(){
		List<Student> list = studentService.findAllStudents();
		return list;
	}
	
	@RequestMapping(path="/student/find", method = RequestMethod.GET)
	public Student findStudentById(@RequestParam(value="id", defaultValue="0") int id) {
		return studentService.findStudentById(id);
	}
	
	@RequestMapping(path="/student/update", method = RequestMethod.PUT)
	public String updateClassNoById(@RequestParam(value="id", defaultValue="0") int id,
			@RequestParam(value="classNo", defaultValue="0") int classNo) {
		int result = studentService.updateClassNoById(id, classNo);
		if(result>0) {
			return "update success";
		}
		else
			return "update fail";
	}
	
	@RequestMapping(path="/student/delete", method = RequestMethod.DELETE)
	public String deleteStudentById(@RequestParam(value="id", defaultValue="0") int id) {
		int result = studentService.deleteStudentById(id);
		if(result>0) {
			return "delete success";
		}
		else
			return "delete fail";
	}
    
}
