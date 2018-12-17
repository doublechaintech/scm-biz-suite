package com.doublechaintech.retailscm.companytraining;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class CompanyTrainingSerializer extends RetailscmObjectPlainCustomSerializer<CompanyTraining>{

	@Override
	public void serialize(CompanyTraining companyTraining, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, companyTraining, provider);
		
	}
}


