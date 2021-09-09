package com.skynet.infrastructure.graphservice;

import java.io.Serializable;

class EdgeValueInstance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5803588207506524702L;
	private String from;
	private String to;
	public EdgeValueInstance(){}
	public EdgeValueInstance(String from, String to) {
		this.from = from;
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
}