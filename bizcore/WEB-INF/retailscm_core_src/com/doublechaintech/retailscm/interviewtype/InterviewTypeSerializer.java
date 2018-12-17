package com.doublechaintech.retailscm.interviewtype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class InterviewTypeSerializer extends RetailscmObjectPlainCustomSerializer<InterviewType>{

	@Override
	public void serialize(InterviewType interviewType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, interviewType, provider);
		
	}
}


