package com.terapico.utils;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class DateTimeBuilder {
	protected Date seedDate;
	protected LocalDateTime workingDate;
	protected ZoneId zoneId;
	
	
	public DateTimeBuilder() {
		this(new Date());
	}
	public DateTimeBuilder(Date date) {
		this(date, ZoneId.systemDefault());
	}
	public DateTimeBuilder(Date date, ZoneId zoneId) {
		this.seedDate = date;
		this.zoneId = zoneId;
		this.workingDate = toLocalDate(date);
	}
	public Date getDate() {
		return Date.from(workingDate.atZone(zoneId).toInstant());
	}
	public LocalDateTime getLocalDateTime() {
		return workingDate;
	}
	
	private LocalDateTime toLocalDate(Date input) {
		if (input instanceof java.sql.Date) {
			return new Date(input.getTime()).toInstant().atZone(zoneId).toLocalDateTime();
		}
		return input.toInstant().atZone(zoneId).toLocalDateTime();
	}
	
	// 年 级别的调整
	public DateTimeBuilder startOfYear() {
		workingDate = workingDate.with(TemporalAdjusters.firstDayOfYear());
		return this;
	}
	public DateTimeBuilder endOfYear() {
		workingDate = workingDate.with(TemporalAdjusters.lastDayOfYear());
		return this;
	}
	public DateTimeBuilder nextYear() {
		return addYears(1);
	}
	public DateTimeBuilder previousYear() {
		return addYears(-1);
	}
	public DateTimeBuilder addYears(long Years) {
		workingDate = workingDate.plusYears(Years);
		return this;
	}
	// 月 级别的调整
	public DateTimeBuilder startOfMonth() {
		workingDate = workingDate.with(TemporalAdjusters.firstDayOfMonth());
		return this;
	}
	public DateTimeBuilder endOfMonth() {
		workingDate = workingDate.with(TemporalAdjusters.lastDayOfMonth());
		return this;
	}
	public DateTimeBuilder nextMonth() {
		return addMonths(1);
	}
	public DateTimeBuilder previousMonth() {
		return addMonths(-1);
	}
	public DateTimeBuilder addMonths(long months) {
		workingDate = workingDate.plusMonths(months);
		return this;
	}
	// 一周内的时间
	public DateTimeBuilder dayOfWeek(DayOfWeek dayOfWeek) {
		workingDate = workingDate.with(dayOfWeek);
		return this;
	}
	public DateTimeBuilder monday() {
		return dayOfWeek(DayOfWeek.MONDAY);
	}
	public DateTimeBuilder tuesday() {
		return dayOfWeek(DayOfWeek.TUESDAY);
	}
	public DateTimeBuilder wednesday() {
		return dayOfWeek(DayOfWeek.WEDNESDAY);
	}
	public DateTimeBuilder thursday() {
		return dayOfWeek(DayOfWeek.THURSDAY);
	}
	public DateTimeBuilder friday() {
		return dayOfWeek(DayOfWeek.FRIDAY);
	}
	public DateTimeBuilder saturday() {
		return dayOfWeek(DayOfWeek.SATURDAY);
	}
	public DateTimeBuilder sunday() {
		return dayOfWeek(DayOfWeek.SUNDAY);
	}
	
	// 天级别的调整
	public DateTimeBuilder startOfDay() {
		workingDate = workingDate.toLocalDate().atStartOfDay();
		return this;
	}
	public DateTimeBuilder endOfDay() {
		workingDate = workingDate.toLocalDate().atTime(LocalTime.MAX);
		return this;
	}
	public DateTimeBuilder nextDay() {
		return addDays(1);
	}
	public DateTimeBuilder previousDay() {
		return addDays(-1);
	}
	public DateTimeBuilder addDays(long days) {
		workingDate = workingDate.plusDays(days);
		return this;
	}
	// 日 内的调整
	/** 指定时间 */
	public DateTimeBuilder atTime(int hour, int min, int sec) {
		workingDate = workingDate.toLocalDate().atTime(hour, min, sec);
		return this;
	}
	/** 指定时间 */
	public DateTimeBuilder atTime(int hour, int min) {
		workingDate = workingDate.toLocalDate().atTime(hour, min);
		return this;
	}
	/** 指定时间中的 小时, 其他不变 */
	public DateTimeBuilder atHour(int hour) {
		workingDate = workingDate.toLocalDate().atTime(hour, workingDate.toLocalTime().getMinute());
		return this;
	}
	/** 指定时间中的 分钟, 其他不变 */
	public DateTimeBuilder atMinute(int minute) {
		workingDate = workingDate.toLocalDate().atTime(workingDate.toLocalTime().getHour(), minute);
		return this;
	}
	/** 指定时间中的 秒, 其他不变 */
	public DateTimeBuilder atSecond(int second) {
		LocalTime lt = workingDate.toLocalTime();
		workingDate = workingDate.toLocalDate().atTime(lt.getHour(), lt.getMinute(), second);
		return this;
	}
	/** 指定时间为当前时间的整点,例如 12:59分, 变成 12:00 */
	public DateTimeBuilder onTheHour() {
		LocalTime lt = workingDate.toLocalTime();
		workingDate = workingDate.toLocalDate().atTime(lt.getHour(), 0, 0);
		return this;
	}
	public DateTimeBuilder addHours(long hours) {
		workingDate = workingDate.plusHours(hours);
		return this;
	}
	public DateTimeBuilder addMinutes(long minutes) {
		workingDate = workingDate.plusMinutes(minutes);
		return this;
	}
	public DateTimeBuilder addSeconds(long seconds) {
		workingDate = workingDate.plusSeconds(seconds);
		return this;
	}
	
	
}
