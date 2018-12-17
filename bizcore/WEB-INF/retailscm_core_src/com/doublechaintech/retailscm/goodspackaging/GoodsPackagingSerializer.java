package com.doublechaintech.retailscm.goodspackaging;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class GoodsPackagingSerializer extends RetailscmObjectPlainCustomSerializer<GoodsPackaging>{

	@Override
	public void serialize(GoodsPackaging goodsPackaging, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, goodsPackaging, provider);
		
	}
}


