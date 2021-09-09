package com.terapico.caf.baseelement;

import java.lang.reflect.Type;

public class Field {
	private String name;
	private String label;
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	private String defaultValue;
	private Type type;
	
	public Type getType() {
		return type;
	}

	public String getTypeExpr() {
		Class clazz=(Class)type;
		return clazz.getName();
	}
	public void setType(Type type) {
		this.type = type;
	}

	public  Field(String name,String defaultValue)
	{
		this.name=name;
		this.defaultValue=defaultValue;
		
	}
	
	public Field() {

	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}
