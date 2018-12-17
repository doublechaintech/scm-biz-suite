package com.doublechaintech.retailscm.retailstoreorderprocessing;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreOrderProcessingSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreOrderProcessing>{

	@Override
	public void serialize(RetailStoreOrderProcessing retailStoreOrderProcessing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderProcessing, provider);
		
	}
}


