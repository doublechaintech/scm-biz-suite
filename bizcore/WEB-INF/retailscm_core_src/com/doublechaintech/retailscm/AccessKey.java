package com.doublechaintech.retailscm;

public class AccessKey extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String columnName;
	private Object value;
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public String toString(){
		
		return this.getColumnName()+": "+getValue();
		
	}
}
