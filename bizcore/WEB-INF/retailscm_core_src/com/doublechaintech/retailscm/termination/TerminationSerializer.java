package com.doublechaintech.retailscm.termination;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class TerminationSerializer extends RetailscmObjectPlainCustomSerializer<Termination>{

	@Override
	public void serialize(Termination termination, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, termination, provider);
		
	}
}


