package com.doublechaintech.retailscm.retailstoreclosing;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreClosingSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreClosing>{

	@Override
	public void serialize(RetailStoreClosing retailStoreClosing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreClosing, provider);
		
	}
}


