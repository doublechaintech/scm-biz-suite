package com.skynet.infrastructure;

import com.terapico.caf.baseelement.Event;

public interface EventService {
	void sendEvent(Event event);
}
