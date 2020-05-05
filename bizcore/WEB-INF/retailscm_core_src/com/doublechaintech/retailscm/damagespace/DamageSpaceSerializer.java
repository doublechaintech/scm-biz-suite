package com.doublechaintech.retailscm.damagespace;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class DamageSpaceSerializer extends RetailscmObjectPlainCustomSerializer<DamageSpace>{

	@Override
	public void serialize(DamageSpace damageSpace, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, damageSpace, provider);
		
	}
}


