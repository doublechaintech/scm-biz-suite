package com.doublechaintech.retailscm.goodsallocation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class GoodsAllocationSerializer extends RetailscmObjectPlainCustomSerializer<GoodsAllocation>{

	@Override
	public void serialize(GoodsAllocation goodsAllocation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, goodsAllocation, provider);
		
	}
}


