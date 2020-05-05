package com.doublechaintech.retailscm.supplyorder;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class SupplyOrderSerializer extends RetailscmObjectPlainCustomSerializer<SupplyOrder>{

	@Override
	public void serialize(SupplyOrder supplyOrder, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrder, provider);
		
	}
}


