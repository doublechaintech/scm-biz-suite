package com.doublechaintech.retailscm.slide;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class SlideSerializer extends RetailscmObjectPlainCustomSerializer<Slide>{

	@Override
	public void serialize(Slide slide, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, slide, provider);
		
	}
}


