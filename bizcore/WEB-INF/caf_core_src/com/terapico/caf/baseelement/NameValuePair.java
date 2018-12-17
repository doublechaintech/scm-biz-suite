package com.terapico.caf.baseelement;

public class NameValuePair {
	private Object name;
	private Object value;
	
	public NameValuePair(Object n, Object v){
		this.name=n;
		this.value=v;
	}
	
	public Object getName() {
		return name;
	}
	public void setName(Object name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
}
