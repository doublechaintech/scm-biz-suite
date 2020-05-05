package com.doublechaintech.retailscm.occupationtype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class OccupationTypeSerializer extends RetailscmObjectPlainCustomSerializer<OccupationType>{

	@Override
	public void serialize(OccupationType occupationType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, occupationType, provider);
		
	}
}


