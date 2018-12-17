package com.doublechaintech.retailscm.professioninterview;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class ProfessionInterviewSerializer extends RetailscmObjectPlainCustomSerializer<ProfessionInterview>{

	@Override
	public void serialize(ProfessionInterview professionInterview, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, professionInterview, provider);
		
	}
}


