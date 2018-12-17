package com.doublechaintech.retailscm.consumerorderapproval;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class ConsumerOrderApprovalSerializer extends RetailscmObjectPlainCustomSerializer<ConsumerOrderApproval>{

	@Override
	public void serialize(ConsumerOrderApproval consumerOrderApproval, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderApproval, provider);
		
	}
}


