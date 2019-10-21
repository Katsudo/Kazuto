package com.chiefclouds.simplejdbcapp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String format(Date date) {
		return sdf.format(date);
		
	}

}
