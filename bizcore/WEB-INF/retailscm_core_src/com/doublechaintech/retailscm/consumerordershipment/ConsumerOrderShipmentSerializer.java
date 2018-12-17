package com.doublechaintech.retailscm.consumerordershipment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class ConsumerOrderShipmentSerializer extends RetailscmObjectPlainCustomSerializer<ConsumerOrderShipment>{

	@Override
	public void serialize(ConsumerOrderShipment consumerOrderShipment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, consumerOrderShipment, provider);
		
	}
}


