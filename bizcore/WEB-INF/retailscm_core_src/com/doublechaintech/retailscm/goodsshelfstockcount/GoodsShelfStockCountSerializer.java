package com.doublechaintech.retailscm.goodsshelfstockcount;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class GoodsShelfStockCountSerializer extends RetailscmObjectPlainCustomSerializer<GoodsShelfStockCount>{

	@Override
	public void serialize(GoodsShelfStockCount goodsShelfStockCount, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, goodsShelfStockCount, provider);
		
	}
}


