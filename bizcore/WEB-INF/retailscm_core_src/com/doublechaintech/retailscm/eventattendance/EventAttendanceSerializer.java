package com.doublechaintech.retailscm.eventattendance;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class EventAttendanceSerializer extends RetailscmObjectPlainCustomSerializer<EventAttendance>{

	@Override
	public void serialize(EventAttendance eventAttendance, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, eventAttendance, provider);
		
	}
}


