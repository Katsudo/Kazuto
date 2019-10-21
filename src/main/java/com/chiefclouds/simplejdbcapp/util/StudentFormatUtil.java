package com.chiefclouds.simplejdbcapp.util;

import com.chiefclouds.simplejdbcapp.entity.Student;

public class StudentFormatUtil {
	
	public static void printTitle() {
		System.out.println("���\t����\t�Ա�\t����\t\tѧ��\t�༶");
	}
	
	public static void printOneStudent(Student student) {
		if(student!=null) {
			System.out.println(student.getId()+"\t"+student.getName()+"\t"+(student.getSex()==0?"��":"Ů")+"\t"+DateFormatUtil.format(student.getDob())+
					"\t"+student.getStudentNo()+"\t"+student.getClassNo());
		}
	}

}
