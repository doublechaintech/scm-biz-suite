package com.terapico.caf.baseelement;

import com.terapico.utils.MapUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ParamInfo {
	protected String title;
	protected String type = "input";
	protected List<Map<String, String>> candidateValues;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Map<String, String>> getCandidateValues() {
		return candidateValues;
	}
	public void setCandidateValues(List<Map<String, String>> candidateValues) {
		this.candidateValues = candidateValues;
	}
	public void addCandidate(String key, String value) {
		if (candidateValues == null) {
			candidateValues = new ArrayList<>();
		}
		candidateValues.add(MapUtil.put("key", key).put("value", value).into_map(String.class));
		this.setType("select");
	}
	
	
}
