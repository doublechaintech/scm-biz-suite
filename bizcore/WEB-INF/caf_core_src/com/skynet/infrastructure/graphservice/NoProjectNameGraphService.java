package com.skynet.infrastructure.graphservice;

public class NoProjectNameGraphService extends GraphServiceImpl {

	@Override
	protected String withProjectName(String projectName) {
		return "";
	}

	@Override
	protected String appendProjectName(String projectName) {
		return "";
	}
	
}
