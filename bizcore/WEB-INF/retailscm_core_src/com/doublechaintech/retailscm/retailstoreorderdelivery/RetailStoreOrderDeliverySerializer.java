package com.doublechaintech.retailscm.retailstoreorderdelivery;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreOrderDeliverySerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreOrderDelivery>{

	@Override
	public void serialize(RetailStoreOrderDelivery retailStoreOrderDelivery, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderDelivery, provider);
		
	}
}


