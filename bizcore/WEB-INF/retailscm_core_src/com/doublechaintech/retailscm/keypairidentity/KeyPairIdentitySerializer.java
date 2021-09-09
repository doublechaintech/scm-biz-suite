package com.doublechaintech.retailscm.keypairidentity;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class KeyPairIdentitySerializer extends RetailscmObjectPlainCustomSerializer<KeyPairIdentity>{

	@Override
	public void serialize(KeyPairIdentity keyPairIdentity, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, keyPairIdentity, provider);
		
	}
}


