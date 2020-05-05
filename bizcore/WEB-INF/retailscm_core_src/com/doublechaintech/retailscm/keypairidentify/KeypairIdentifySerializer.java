package com.doublechaintech.retailscm.keypairidentify;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class KeypairIdentifySerializer extends RetailscmObjectPlainCustomSerializer<KeypairIdentify>{

	@Override
	public void serialize(KeypairIdentify keypairIdentify, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, keypairIdentify, provider);
		
	}
}


