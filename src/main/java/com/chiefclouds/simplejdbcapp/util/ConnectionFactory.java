package com.chiefclouds.simplejdbcapp.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 连接工具类
 * 
 * @author Administrator
 */
public class ConnectionFactory {
	// 用来保存配置文件中的四个参数
	private static String driver;
	private static String url;
	private static String name;
	private static String password;

	// 静态代码块:类加载时执行,只会执行一次
	static {
		// 读取配置文件的数据,保存到四个静态属性中
		Properties properties = new Properties();
		try {
			// 加载属性文件数据到集合对象中,以键值对形式存储数据
			// 当前利用反射写法获取指定文件的输入字节流,要求同包下
			properties.load(ConnectionFactory.class.getResourceAsStream("jdbc_info.properties"));
			// 把四个配置信息存储到静态变量中,方便后面使用
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			name = properties.getProperty("name");
			password = properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取连接对象
	public static Connection getConnection() throws Exception {
		// 注册驱动
		Class.forName(driver);
		// 与数据库建立连接
		Connection conn = DriverManager.getConnection(url, name, password);
		return conn;
	}

	// 封装关闭资源方法
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 封装关闭资源方法
	public static void close(PreparedStatement pstmt, Connection conn) {
		close(null, pstmt, conn);
	}
	
	public static void close(PreparedStatement pstmt) {
		close(null,pstmt,null);
	}
	
	public static void close(Connection conn) {
		close(null,null,conn);
	}
	
	public static void close(ResultSet rs) {
		close(rs,null,null);
	}

	/*
	public static void main(String[] args) {
		// 测试一下是否可以获取连接对象
		try {
			System.out.println(getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/

	
}
