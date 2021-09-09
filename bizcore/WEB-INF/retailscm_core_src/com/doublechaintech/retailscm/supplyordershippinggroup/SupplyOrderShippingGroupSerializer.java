package com.doublechaintech.retailscm.supplyordershippinggroup;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class SupplyOrderShippingGroupSerializer extends RetailscmObjectPlainCustomSerializer<SupplyOrderShippingGroup>{

	@Override
	public void serialize(SupplyOrderShippingGroup supplyOrderShippingGroup, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderShippingGroup, provider);
		
	}
}


