package com.skynet.infrastructure.kafkaservice;


import com.skynet.infrastructure.EventService;
import com.terapico.caf.baseelement.Event;

public class DummyEventService implements EventService{

	@Override
	public void sendEvent(Event event) {
		
	}

}
