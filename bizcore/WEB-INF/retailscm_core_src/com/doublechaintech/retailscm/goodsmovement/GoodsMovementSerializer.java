package com.doublechaintech.retailscm.goodsmovement;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class GoodsMovementSerializer extends RetailscmObjectPlainCustomSerializer<GoodsMovement>{

	@Override
	public void serialize(GoodsMovement goodsMovement, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, goodsMovement, provider);
		
	}
}


