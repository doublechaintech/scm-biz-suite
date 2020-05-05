package com.doublechaintech.retailscm.warehouseasset;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class WarehouseAssetSerializer extends RetailscmObjectPlainCustomSerializer<WarehouseAsset>{

	@Override
	public void serialize(WarehouseAsset warehouseAsset, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, warehouseAsset, provider);
		
	}
}


