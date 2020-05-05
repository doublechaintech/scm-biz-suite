package com.doublechaintech.retailscm.retailstoredecoration;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreDecorationSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreDecoration>{

	@Override
	public void serialize(RetailStoreDecoration retailStoreDecoration, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreDecoration, provider);
		
	}
}


