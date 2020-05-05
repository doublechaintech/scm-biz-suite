package com.terapico.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateTimeUtil {
	/**
	 * 
	 * <ul>
	 * <li>EarlierThan: 时间段1开始了,时间段2还没开始.</li>
	 * <li>EndIn: 时间段1早于时间段2开始, 在时间段2期间结束. </li>
	 * <li>Inside: 时间段1的开始和结束都在时间段2内.</li>
	 * <li>StartIn: 时间段1在时间段2内开始,在时间段2结束后才结束.</li>
	 * <li>After: 时间段1在时间段2结束后才开始.</li>
	 * <li>Contains: 时间段1包含整个时间段2.</li>
	 * 
	 * @author clariones
	 *
	 */
	public static enum DateRangeRelation  {
		EarlierThan, // 时间段1开始了,时间段2还没开始
		EndIn, // 时间段1早于时间段2开始, 在时间段2期间结束
		Inside, // 时间段1的开始和结束都在时间段2内
		StartIn, // 时间段1在时间段2内开始,在时间段2结束后才结束
		After, // 时间段1在时间段2结束后才开始
		Contains	// 时间段1包含整个时间段2
	}

	public static long SECOND_IN_MS = 1000L;
	public static long MINUTE_IN_MS = SECOND_IN_MS * 60;
	public static long HOUR_IN_MS = MINUTE_IN_MS * 60;
	public static long DAY_IN_MS = HOUR_IN_MS * 24;
	public static long WEEK_IN_MS = DAY_IN_MS * 7;

	public static final DateTimeFormatter DAY_FORMAT = DateTimeFormatter.ofPattern("yyyy-M-d");
	public static final DateTimeFormatter DAY_FORMAT_BY_SLASH = DateTimeFormatter.ofPattern("yyyy/M/d");
	public static final DateTimeFormatter DAY_TIME_MINUTE_FORMAT = DateTimeFormatter.ofPattern("yyyy-M-d H:m");
	public static final DateTimeFormatter DAY_TIME_MINUTE_FORMAT_BY_SLASH = DateTimeFormatter.ofPattern("yyyy/M/d H:m");
	public static final DateTimeFormatter DAY_TIME_MINUTE_FORMAT_S = DateTimeFormatter.ofPattern("yyyy-M-dd'T'H:m");
	public static final DateTimeFormatter DAY_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-M-d H:m:s");
	public static final DateTimeFormatter DAY_TIME_FORMAT_S = DateTimeFormatter.ofPattern("yyyy-M-d'T'H:m:s");
	public static final DateTimeFormatter DAY_TIME_FORMAT_SS = DateTimeFormatter.ofPattern("yyyy-M-d'T'H:m:s.SSS'Z'");
	public static final DateTimeFormatter YEAR_MONTH_FORMAT = DateTimeFormatter.ofPattern("yyyy-M");
	public static final DateTimeFormatter YEAR_MONTH_FORMAT_BY_SLASH = DateTimeFormatter.ofPattern("yyyy/M");
	
	public static final String HOUR_MINUTE_FORMAT = "H:m";
	public static final String HOUR_MINUTE_SECOND_FORMAT = "H:m:s";
	public static final String HOUR_MINUTE_SECOND_SS_FORMAT = "H:m:s.S";
	public static final String DATE_HOUR_MINUTE_FORMAT = "yyyy-MM-dd H:m:s";
	
	private static final DateTimeFormatter[] allFormats = new DateTimeFormatter[] { DAY_FORMAT, DAY_TIME_FORMAT,
			DAY_TIME_FORMAT_S, DAY_TIME_MINUTE_FORMAT, DAY_TIME_MINUTE_FORMAT_S, DAY_TIME_FORMAT_SS, YEAR_MONTH_FORMAT,
			DAY_FORMAT_BY_SLASH, DAY_TIME_MINUTE_FORMAT_BY_SLASH, YEAR_MONTH_FORMAT_BY_SLASH};
	private static final String[] timeFormats = new String[] {DATE_HOUR_MINUTE_FORMAT, HOUR_MINUTE_SECOND_SS_FORMAT , HOUR_MINUTE_SECOND_FORMAT, HOUR_MINUTE_FORMAT};
	private static final Map<String, Boolean> ChinaHolidayPatch = new HashMap<>();
	static {
		// 2019 年
		ChinaHolidayPatch.put("2019-01-01", true); // 元旦
		ChinaHolidayPatch.put("2019-02-02", false); 
		ChinaHolidayPatch.put("2019-02-03", false); 
		ChinaHolidayPatch.put("2019-02-04", true); // 春节
		ChinaHolidayPatch.put("2019-02-05", true); 
		ChinaHolidayPatch.put("2019-02-06", true); 
		ChinaHolidayPatch.put("2019-02-07", true); 
		ChinaHolidayPatch.put("2019-02-08", true); 
		ChinaHolidayPatch.put("2019-04-05", true); // 清明
		ChinaHolidayPatch.put("2019-04-28", false);
		ChinaHolidayPatch.put("2019-05-01", true); // 5.1
		ChinaHolidayPatch.put("2019-05-02", true);
		ChinaHolidayPatch.put("2019-05-03", true);
		ChinaHolidayPatch.put("2019-05-05", false);
		ChinaHolidayPatch.put("2019-06-07", true);	// 端午
		ChinaHolidayPatch.put("2019-09-13", true);	// 中秋
		ChinaHolidayPatch.put("2019-09-29", false);
		ChinaHolidayPatch.put("2019-10-01", true); // 国庆
		ChinaHolidayPatch.put("2019-10-02", true);
		ChinaHolidayPatch.put("2019-10-03", true);
		ChinaHolidayPatch.put("2019-10-04", true);
		ChinaHolidayPatch.put("2019-10-07", true);
		ChinaHolidayPatch.put("2019-10-12", false);
		// 2020年
		ChinaHolidayPatch.put("2020-01-01", true); // 元旦
		ChinaHolidayPatch.put("2020-01-19", false); // 春节
		ChinaHolidayPatch.put("2020-01-24", true);
		ChinaHolidayPatch.put("2020-01-27", true);
		ChinaHolidayPatch.put("2020-01-28", true);
		ChinaHolidayPatch.put("2020-01-29", true);
		ChinaHolidayPatch.put("2020-01-30", true);
		ChinaHolidayPatch.put("2020-02-01", false);
		ChinaHolidayPatch.put("2020-04-06", true); // 清明
		ChinaHolidayPatch.put("2020-05-01", true); // 5.1
		ChinaHolidayPatch.put("2020-06-25", true);	// 端午
		ChinaHolidayPatch.put("2020-06-26", true);
		ChinaHolidayPatch.put("2020-06-28", false);
		ChinaHolidayPatch.put("2020-10-01", true); // 国庆-中秋
		ChinaHolidayPatch.put("2020-10-02", true);
		ChinaHolidayPatch.put("2020-10-05", true);
		ChinaHolidayPatch.put("2020-10-06", true);
		ChinaHolidayPatch.put("2020-10-07", true);
		ChinaHolidayPatch.put("2020-10-10", false);
		
	}
	
	public static String toStringAsDay(Date date) {
		if (date == null) {
			return null;
		}
		return DateTimeFormatter.ISO_DATE.format(toLocalDateTime(date));
	}

	public static Date parseInputDateTime(String valueOf) {
		if (valueOf == null) {
			return null;
		}
		if (valueOf.matches("\\d+")) {
			try {
				long tsInMs = Long.parseLong(valueOf);
				return new Date(tsInMs);
			} catch (Exception e) {
			}
		}
		for (DateTimeFormatter fmt : allFormats) {
			try {
				LocalDateTime temp = LocalDateTime.parse(valueOf, fmt);
				if (temp != null) {
					return toDate(temp);
				}
			} catch (Exception e) {
			}
			try {
				LocalDate tempDate = LocalDate.parse(valueOf, fmt);
				if (tempDate != null) {
					return toDate(tempDate.atStartOfDay());
				}
			} catch (Exception e) {
			}
		}
		return null;
	}
	
	
	public static Date parseInputTime(String valueOf) {
		if (valueOf == null) {
			return null;
		}
		if (valueOf.matches("\\d+")) {
			try {
				long tsInMs = Long.parseLong(valueOf);
				return new Date(tsInMs);
			} catch (Exception e) {
			}
		}
		for (String fmt : timeFormats) {
			try {
				DateFormat sdf = new SimpleDateFormat(fmt);
				Date temp = sdf.parse(valueOf);
				if (temp != null) {
					return temp;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Date SetTimeInADay(Date date, int hour, int minute, int second) {
		Calendar cald = Calendar.getInstance();
		cald.setTime(date);
		cald.set(Calendar.HOUR_OF_DAY, hour);
		cald.set(Calendar.MINUTE, minute);
		cald.set(Calendar.SECOND, second);
		return cald.getTime();
	}

	public static Date addDays(Date date, int days, boolean byEndOfBoundary) {
		if (!byEndOfBoundary) {
			return standOn(date).addDays(days).getDate();
		}
		if (days > 0) {
			// 如果是向后, 那么到 日尾
			return standOn(date).addDays(days).endOfDay().getDate();
		}
		return standOn(date).addDays(days).startOfDay().getDate();
	}
	public static Date addHours(Date date, int hours) {
		return standOn(date).addHours(hours).getDate();
	}
	public static Date addMinutes(Date date, int minutes) {
		return standOn(date).addMinutes(minutes).getDate();
	}
	public static Date addSeconds(Date date, int seconds) {
		return standOn(date).addSeconds(seconds).getDate();
	}
	public static Date addMS(Date date, long ms) {
		return new Date(date.getTime() + ms);
	}
	private static Date toDate(LocalDateTime input) {
		return Date.from(input.atZone(ZoneId.systemDefault()).toInstant());
	}

	private static LocalDateTime toLocalDateTime(Date input) {
		if (input instanceof java.sql.Date) {
			return new Date(input.getTime()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		}
		return input.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static Date toEndOfDay(Date date) {
		return SetTimeInADay(date, 23, 59, 59);
	}

	public static Date toStartOfDay(Date date) {
		return SetTimeInADay(date, 0, 0, 0);
	}

	public static int calcDifferDays(Date startDay, Date endDay) {
		LocalDateTime d1 = toLocalDateTime(startDay);
		LocalDateTime d2 = toLocalDateTime(endDay);
		Duration duration = Duration.between(d1, d2);
		return (int) duration.toDays();
	}

	public static int calcDifferHours(Date startTime, Date endTime) {
		LocalDateTime d1 = toLocalDateTime(startTime);
		LocalDateTime d2 = toLocalDateTime(endTime);
		Duration duration = Duration.between(d1, d2);
		return (int) duration.toHours();
	}
	
	public static int calcDifferMinutes(Date startTime, Date endTime) {
		LocalDateTime d1 = toLocalDateTime(startTime);
		LocalDateTime d2 = toLocalDateTime(endTime);
		Duration duration = Duration.between(d1, d2);
		return (int) duration.toMinutes();
	}

	public static long calcDifferSeconds(Date startTime, Date endTime) {
		LocalDateTime d1 = toLocalDateTime(startTime);
		LocalDateTime d2 = toLocalDateTime(endTime);
		Duration duration = Duration.between(d1, d2);
		return duration.getSeconds();
	}
	
	public static long calcDifferMS(Date startTime, Date endTime) {
		return endTime.getTime() - startTime.getTime();
	}
	
	public static Date getDate(String dateString) {
		return parseInputDateTime(dateString);
	}

	public static Date addMonths(Date date, int months) {
		Date result = toDate(toLocalDateTime(date).plusMonths(months));
		return result;
	}

	/**
	 * use {@code DateTimeUtil.standOn(date).startOfMonth().getDate()} instead
	 * @param date
	 * @return
	 */
	@Deprecated
	public static Date toStartOfMonth(Date date) {
		return toStartOfDay(toDate(toLocalDateTime(date).with(TemporalAdjusters.firstDayOfMonth())));
	}

	public static Date toEndOfLastMonth(Date date) {
		return toEndOfDay(toDate(toLocalDateTime(date).plusMonths(-1).with(TemporalAdjusters.lastDayOfMonth())));
	}
	
	public static boolean isSameYear(Date date1, Date date2) {
		Calendar cald1 = Calendar.getInstance();
		Calendar cald2 = Calendar.getInstance();
		cald1.setTime(date1);
		cald2.setTime(date2);
		return cald1.get(Calendar.YEAR) == cald2.get(Calendar.YEAR);
	}

	public static boolean isSameMonth(Date date1, Date date2) {
		Calendar cald1 = Calendar.getInstance();
		Calendar cald2 = Calendar.getInstance();
		cald1.setTime(date1);
		cald2.setTime(date2);
		return cald1.get(Calendar.YEAR) == cald2.get(Calendar.YEAR)
				&& cald1.get(Calendar.MONTH) == cald2.get(Calendar.MONTH);
	}

	public static boolean isSameDay(Date date1, Date date2) {
		Calendar cald1 = Calendar.getInstance();
		Calendar cald2 = Calendar.getInstance();
		cald1.setTime(date1);
		cald2.setTime(date2);
		return cald1.get(Calendar.YEAR) == cald2.get(Calendar.YEAR)
				&& cald1.get(Calendar.MONTH) == cald2.get(Calendar.MONTH)
				&& cald1.get(Calendar.DAY_OF_MONTH) == cald2.get(Calendar.DAY_OF_MONTH);
	}

	public static String formatDate(Date data, String format) {
		if (data == null) {
			return "";
		}
		if (format == null) {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z").format(data);
		}
		String result = CustomDateFormat(data, format);
		if (result != null) {
			return result;
		}
		return new SimpleDateFormat(format).format(data);
	}

	protected static String CustomDateFormat(Date data, String format) {
		if (format.equals("1_hour_or_earlier") || format.equals("1_day_or_earlier")
				|| format.equals("fuzz_after_1_hour")) {
			LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
			LocalDateTime registerTime = LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault());
			if (now.minusHours(1L).isAfter(registerTime)) {
				Period period = Period.between(registerTime.toLocalDate(), now.toLocalDate());
				int years = period.getYears();
				if (years > 0) {
					return years + "年前";
				}
				int months = period.getMonths();
				if (months > 0) {
					return months + "个月前";
				}
				long days = period.getDays();
				if (days > 0L) {
					return days + "天前";
				}
				Duration duration = Duration.between(registerTime, now);
				long hours = duration.toHours();
				return hours + "小时前";
			}
			return new SimpleDateFormat("HH:mm").format(data);
		}

		return null;
	}

	public static String formatDuration(long tsInMs, String format) {
		// 目前忽略format
		return formatMsToDefaultString(tsInMs);

	}

	private static String formatMsToDefaultString(long tsInMs) {
		if (tsInMs == 0) {
			return "0毫秒";
		}
		String result = "";
		long timeValue = Math.abs(tsInMs);
		String[] units = new String[] { "毫秒", "秒", "分钟", "小时", "天" };
		long[] radis = new long[] { 1000L, 60L, 60L, 24L, Long.MAX_VALUE };
		for (int i = 0; i < units.length; i++) {
			long valInCurRadix = timeValue % radis[i];
			if (valInCurRadix == 0) {
				result = "零" + result;
			} else {
				result = String.valueOf(valInCurRadix) + units[i] + result;
			}
			timeValue = timeValue / radis[i];
			if (timeValue == 0) {
				break;
			}
		}
		result = result.replaceAll("零+", "零");
		result = result.replaceAll("零+$", "");
		if (tsInMs < 0) {
			return "负" + result;
		}
		return result;
	}

	public static Date getDateBefore(long timeInMS) {
		Date result = toDate(LocalDateTime.now().minusSeconds(timeInMS/1000));
		return result;
	}

	public static Date getFirstDayOfThisMonth() {
		return toStartOfMonth(new Date());
	}
	
	public static boolean isChineseHoliday(Date date) {
		return isHoliday(ChinaHolidayPatch, date);
	}

	private static boolean isHoliday(Map<String, Boolean> holidayInfo, Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		String dayStr = String.format("%04d-%02d-%02d", c.get(Calendar.YEAR), c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH));
		Boolean b = holidayInfo.get(dayStr);
		if (b!=null) {
			return b;
		}
		int d = c.get(Calendar.DAY_OF_WEEK);
		return d == Calendar.SATURDAY || d == Calendar.SUNDAY;
	}
	
	public static DateTimeBuilder standOn(Date date) {
		return new DateTimeBuilder(date);
	}
	public static DateTimeBuilder standOn(Date date, ZoneId zoneId) {
		return new DateTimeBuilder(date, zoneId);
	}

	public static DateRangeRelation compareDateRange(Date start1, Date end1, Date start2, Date end2) {
		if (end1.before(start1)) {
			Date t = start1;
			start1 = end1;
			end1 = t;
		}
		if (end2.before(start2)) {
			Date t = start2;
			start2 = end2;
			end1 = t;
		}
		if (start1.before(start2) && !end1.after(start2)) {
			return DateRangeRelation.EarlierThan;
		}
		if (!start1.after(start2) && !end1.before(end2)) {
			return DateRangeRelation.Contains;
		}
		if (!start1.after(start2) && end1.before(end2)) {
			return DateRangeRelation.EndIn;
		}
		if (start1.after(start2) && end1.before(end2)) {
			return DateRangeRelation.Inside;
		}
		if (start1.before(end2) && !end1.before(end2)) {
			return DateRangeRelation.StartIn;
		}
		if (!start1.before(end2) && end1.after(end2)) {
			return DateRangeRelation.After;
		}
		String message = String.format("cannot compare (%s,%s) with (%s,%s)", formatDate(start1, null),
				formatDate(end1, null), formatDate(start2, null), formatDate(end2, null));
		throw new RuntimeException(message);
	}

	public static void main(String[] args) {
		System.out.print(parseInputTime("1:3"));
		
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
//		String date = "12:30";
//		LocalDateTime dateTime = LocalDateTime.parse(date, format);
//		System.out.println(dateTime);
	}
	
}
