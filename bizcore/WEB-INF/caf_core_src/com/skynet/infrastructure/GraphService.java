package com.skynet.infrastructure;


import com.skynet.infrastructure.graphservice.BaseQuery;
import com.skynet.infrastructure.graphservice.ResultList;

import java.util.List;

public interface GraphService {

	List<String[]> relationsOf(String projectName, String fromLabel, String fromId, String toLable, String toId);

	default  <T> ResultList<T> query(BaseQuery query, Class<T> clazz) throws Exception {
		return null;
	}
}
