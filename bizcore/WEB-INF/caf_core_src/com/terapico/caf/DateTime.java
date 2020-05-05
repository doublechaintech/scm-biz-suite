package com.terapico.caf;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateTime extends Date {
	public DateTime(){
		
	}
	public DateTime(long dateTimeValue){
		super(dateTimeValue);
	}
	private static final long serialVersionUID = 1L;
	public static DateTime fromDate(Date date){
		if(date==null){
			return null;
		}
		DateTime dateTime = new DateTime();
		dateTime.setTime(date.getTime());
		return dateTime;
	}
	public static DateTime now(){
		return fromDate(new java.util.Date());
	}
	public String shortDateForm() {
		String pattern = "yyyyMMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}
}


