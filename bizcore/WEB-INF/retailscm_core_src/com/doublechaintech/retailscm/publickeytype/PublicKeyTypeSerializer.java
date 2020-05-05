package com.doublechaintech.retailscm.publickeytype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class PublicKeyTypeSerializer extends RetailscmObjectPlainCustomSerializer<PublicKeyType>{

	@Override
	public void serialize(PublicKeyType publicKeyType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, publicKeyType, provider);
		
	}
}


