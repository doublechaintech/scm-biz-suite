package com.doublechaintech.retailscm.terminationtype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class TerminationTypeSerializer extends RetailscmObjectPlainCustomSerializer<TerminationType>{

	@Override
	public void serialize(TerminationType terminationType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, terminationType, provider);
		
	}
}


