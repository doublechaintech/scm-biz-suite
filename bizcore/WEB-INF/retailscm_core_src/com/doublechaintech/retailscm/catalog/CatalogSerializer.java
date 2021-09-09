package com.doublechaintech.retailscm.catalog;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class CatalogSerializer extends RetailscmObjectPlainCustomSerializer<Catalog>{

	@Override
	public void serialize(Catalog catalog, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, catalog, provider);
		
	}
}


