package com.doublechaintech.retailscm.skilltype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class SkillTypeSerializer extends RetailscmObjectPlainCustomSerializer<SkillType>{

	@Override
	public void serialize(SkillType skillType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, skillType, provider);
		
	}
}


