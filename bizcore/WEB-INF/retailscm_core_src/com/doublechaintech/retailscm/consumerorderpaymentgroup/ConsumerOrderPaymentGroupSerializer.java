package com.doublechaintech.retailscm.consumerorderpaymentgroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class ConsumerOrderPaymentGroupSerializer extends RetailscmObjectPlainCustomSerializer<ConsumerOrderPaymentGroup>{

	@Override
	public void serialize(ConsumerOrderPaymentGroup consumerOrderPaymentGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderPaymentGroup, provider);
		
	}
}


