package com.chiefclouds.simplejdbcapp.entity;

import java.sql.Timestamp;

public class Student {
	private int id;
	private String name;
	private int sex;
	private Timestamp dob;
	private int studentNo;
	private int classNo;
	
	public Student() {}

	public Student(int id, String name, int sex, Timestamp dob, int studentNo, int classNo) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.dob = dob;
		this.studentNo = studentNo;
		this.classNo = classNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Timestamp getDob() {
		return dob;
	}

	public void setDob(Timestamp dob) {
		this.dob = dob;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", dob=" + dob + ", studentNo="
				+ studentNo + ", classNo=" + classNo + "]";
	}
}