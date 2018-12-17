package com.terapico.caf.baseelement;

public class Action {
	String name;
	
	public  Action(final String name)
	{
		this.name=name;
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getTitle(){
		String []segs = name.split("/");
		if(segs.length>1){
			return segs[1];
		}
		return name;
	}
	
}
