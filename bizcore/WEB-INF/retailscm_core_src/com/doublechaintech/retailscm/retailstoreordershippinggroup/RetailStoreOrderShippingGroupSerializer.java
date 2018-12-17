package com.doublechaintech.retailscm.retailstoreordershippinggroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreOrderShippingGroupSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreOrderShippingGroup>{

	@Override
	public void serialize(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreOrderShippingGroup, provider);
		
	}
}


