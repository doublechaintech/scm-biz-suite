package com.doublechaintech.retailscm.transporttasktrack;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class TransportTaskTrackSerializer extends RetailscmObjectPlainCustomSerializer<TransportTaskTrack>{

	@Override
	public void serialize(TransportTaskTrack transportTaskTrack, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, transportTaskTrack, provider);
		
	}
}


