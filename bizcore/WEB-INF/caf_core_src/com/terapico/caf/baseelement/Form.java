package com.terapico.caf.baseelement;

import java.util.ArrayList;
import java.util.List;

public class Form {
	private List<Field>fields;
	private List<Action>actions;

	public List<Field> getFields() {
		return fields;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}
	public void addField(Field field) {
		if(this.fields==null){
			fields=new ArrayList<Field>();
		}
		fields.add(field);
	}
	public void addAction(Action action) {
		if(this.actions==null){
			actions=new ArrayList<Action>();
		}
		actions.add(action);
	}
	
}
