package com.terapico.caf;

import java.util.List;
import java.util.Map;

public class WebUserContext implements UserContext {
	private String username;
	private String ipAddress;
	private Map<String,Object> cacheEntrys;
	private List<LogEntry>requestLog;
	private List<LogEntry>requestErrorLog;
	public List<LogEntry> getRequestErrorLog() {
		return requestErrorLog;
	}
	public void setRequestErrorLog(List<LogEntry> requestErrorLog) {
		this.requestErrorLog = requestErrorLog;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Map<String, Object> getCacheEntrys() {
		return cacheEntrys;
	}
	public void setCacheEntrys(Map<String, Object> cacheEntrys) {
		this.cacheEntrys = cacheEntrys;
	}
	public List<LogEntry> getRequestLog() {
		return requestLog;
	}
	public void setRequestLog(List<LogEntry> requestLog) {
		this.requestLog = requestLog;
	}
	
	
}
