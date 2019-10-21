package com.chiefclouds.simplejdbcapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.chiefclouds.simplejdbcapp.dao.IStudentDao;
import com.chiefclouds.simplejdbcapp.entity.Student;
import com.chiefclouds.simplejdbcapp.util.ConnectionFactory;
import com.chiefclouds.simplejdbcapp.util.StudentRowMapper;

@Repository
public class StudentDaoImpl implements IStudentDao {
	/*
	@Autowired
	DataSource dataSource;
	private JdbcTemplate getJDBCTemplate() {
		return new JdbcTemplate(dataSource);
	}
	*/
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Student findStudentByStudentNo(int studentNo) throws Exception {
			String sql = "select id,name,sex,dob,student_no,class_no"
					+ " from t_student where student_no=?";
			try {
				return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), studentNo);
			}catch(Exception e){
				return null;
			}
	}
	

	@Override
	public int addStudent(Student student) throws Exception {
			String sql = "insert into t_student (name,sex,dob,student_no,class_no)"
					+ " values(?,?,?,?,?)";
			return jdbcTemplate.update(sql, student.getName(),student.getSex(),student.getDob(),student.getStudentNo(),student.getClassNo());
	}
	

	@Override
	public List<Student> findAllStudents() throws Exception {
		List<Student> studentList = new ArrayList<Student>();
			String sql = "select id,name,sex,dob,student_no,class_no"
					+ " from t_student";
			studentList = jdbcTemplate.query(sql, new StudentRowMapper());
			return studentList;
	}
	

	@Override
	public Student findStudentById(int id) throws Exception {
			String sql = "select id,name,sex,dob,student_no,class_no"
					+ " from t_student where id=?";
			return jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
	}

	@Override
	public int updateClassNoById(int id, int classNo) throws Exception {
			String sql = "update t_student set class_no=? where id=?";
			return jdbcTemplate.update(sql, classNo,id);

	}


	@Override
	public int deleteStudentById(int id) throws Exception {
		String sql = "delete from t_student where id=?";
		return jdbcTemplate.update(sql,id);
	}

}
