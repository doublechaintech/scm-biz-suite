package com.skynet.infrastructure;

import java.util.Map;

public class TerminalMessageService implements MessageService {
	
	@Override
	public void sendMessage(String dest, String fromWho, String template, Map<String, String> parameters)
			throws Exception {
		System.out.println(String.format("==>Send Message with parameters:\n dest=%s, fromWho=%s, template=%s, parameters=%s", 
				dest, fromWho, template, String.valueOf(parameters)));
	}
}