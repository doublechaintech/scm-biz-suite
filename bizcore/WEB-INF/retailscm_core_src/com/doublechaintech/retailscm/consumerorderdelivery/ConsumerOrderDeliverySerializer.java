package com.doublechaintech.retailscm.consumerorderdelivery;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class ConsumerOrderDeliverySerializer extends RetailscmObjectPlainCustomSerializer<ConsumerOrderDelivery>{

	@Override
	public void serialize(ConsumerOrderDelivery consumerOrderDelivery, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderDelivery, provider);
		
	}
}


