package com.doublechaintech.retailscm;

public class KeyValuePair {
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	private String key;
	private Object value;

	public KeyValuePair() {
		super();
	}

	public KeyValuePair(String key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

}


