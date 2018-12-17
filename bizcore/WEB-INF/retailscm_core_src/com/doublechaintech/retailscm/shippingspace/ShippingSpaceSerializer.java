package com.doublechaintech.retailscm.shippingspace;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class ShippingSpaceSerializer extends RetailscmObjectPlainCustomSerializer<ShippingSpace>{

	@Override
	public void serialize(ShippingSpace shippingSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, shippingSpace, provider);
		
	}
}


