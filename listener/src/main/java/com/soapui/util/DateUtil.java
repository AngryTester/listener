package com.soapui.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

	public static String getNowTime() {
		return dateToString(new Date(), "yyyy-MM-dd_HH_mm_ss", Locale.CHINA);
	}

	public static String dateToString(Date date, String pattern, Locale locale) {
		DateFormat ymdhmsFormat = new SimpleDateFormat(pattern, Locale.CHINA);
		return ymdhmsFormat.format(date);
	}

	public static String getDuration(Date startDate, Date endDate) {
		long time = (endDate.getTime() - startDate.getTime()) / 1000;
		int mm = (int) time / 60; // 共计分钟数
		int hh = (int) time / 3600; // 共计小时数
		int dd = (int) hh / 24; // 共计天数
		int ss = (int) (time - mm * 60);// 余秒数
		int ms = (int) (endDate.getTime() - startDate.getTime()) % 1000;// 余毫秒数
		StringBuffer duration = new StringBuffer();
		if (dd > 0) {
			duration.append(dd + "d");
		}
		if (hh > 0) {
			duration.append(hh + "h");
		}
		if (mm > 0) {
			duration.append(mm + "m");
		}
		if (ss > 0) {
			duration.append(ss + "s");
		}
		duration.append(ms + "ms");
		return duration.toString();
	}

}
