package com.doublechaintech.retailscm.consumerordershippinggroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class ConsumerOrderShippingGroupSerializer extends RetailscmObjectPlainCustomSerializer<ConsumerOrderShippingGroup>{

	@Override
	public void serialize(ConsumerOrderShippingGroup consumerOrderShippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderShippingGroup, provider);
		
	}
}


