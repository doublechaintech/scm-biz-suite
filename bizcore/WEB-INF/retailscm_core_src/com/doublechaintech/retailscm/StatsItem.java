package com.doublechaintech.retailscm;
import java.util.ArrayList;
import java.util.List;
public class StatsItem extends Object {
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getInternalName() {
		return internalName;
	}
	public void setInternalName(String internalName) {
		this.internalName = internalName;
	}
	public List<AggrResult> getResult() {
		return result;
	}
	public void setResult(List<AggrResult> result) {
		this.result = result;
	}
	private String displayName;
	private String internalName;
	private List<AggrResult> result;
	
	
	
	
}
