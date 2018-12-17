package com.doublechaintech.retailscm.supplyordershipment;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class SupplyOrderShipmentSerializer extends RetailscmObjectPlainCustomSerializer<SupplyOrderShipment>{

	@Override
	public void serialize(SupplyOrderShipment supplyOrderShipment, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderShipment, provider);
		
	}
}


