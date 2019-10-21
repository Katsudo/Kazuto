package com.chiefclouds.simplejdbcapp.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chiefclouds.simplejdbcapp.entity.Student;

public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("sex"),rs.getTimestamp("dob"),rs.getInt("student_no"),rs.getInt("class_no"));
		return student;
	}

}
