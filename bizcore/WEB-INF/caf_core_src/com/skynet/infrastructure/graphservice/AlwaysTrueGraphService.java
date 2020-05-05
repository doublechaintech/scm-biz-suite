package com.skynet.infrastructure.graphservice;

import java.util.ArrayList;
import java.util.List;

import com.skynet.infrastructure.GraphService;

public class AlwaysTrueGraphService implements GraphService {

	@Override
	public List<String[]> relationsOf(String projectName, String fromLabel, String fromId, String toLable, String toId) {
		String[] relations = {"MXWR"};
		List<String[]> result = new ArrayList<String[]>();
		result.add(relations);
		return result;
	}

}
