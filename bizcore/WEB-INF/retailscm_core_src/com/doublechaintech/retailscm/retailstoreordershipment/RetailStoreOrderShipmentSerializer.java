package com.doublechaintech.retailscm.retailstoreordershipment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreOrderShipmentSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreOrderShipment>{

	@Override
	public void serialize(RetailStoreOrderShipment retailStoreOrderShipment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderShipment, provider);
		
	}
}


