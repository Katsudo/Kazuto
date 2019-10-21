package com.chiefclouds.simplejdbcapp.util;

import java.util.Scanner;
//Scanner�Ĺ�����---һ�㹤����ķ������Ǿ�̬����
public class InputUtil {
	//static:ֻ��һ��,һ�ݼ���
	private static Scanner input = new Scanner(System.in);
	
	//����int
	public static int nextInt() {
		return input.nextInt();
	}
	
	//����double
	public static double nextDouble() {
		return input.nextDouble();
	}
	
	//����String
	public static String next() {
		return input.next();
	}
	
	public static long nextLong() {
		return input.nextLong();
	}
}