package com.doublechaintech.retailscm.levelonecategory;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class LevelOneCategorySerializer extends RetailscmObjectPlainCustomSerializer<LevelOneCategory>{

	@Override
	public void serialize(LevelOneCategory levelOneCategory, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, levelOneCategory, provider);
		
	}
}


