package com.doublechaintech.retailscm.jobapplication;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class JobApplicationSerializer extends RetailscmObjectPlainCustomSerializer<JobApplication>{

	@Override
	public void serialize(JobApplication jobApplication, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, jobApplication, provider);
		
	}
}


