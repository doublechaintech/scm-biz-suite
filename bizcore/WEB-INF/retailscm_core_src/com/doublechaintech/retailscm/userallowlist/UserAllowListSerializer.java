package com.doublechaintech.retailscm.userallowlist;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class UserAllowListSerializer extends RetailscmObjectPlainCustomSerializer<UserAllowList>{

	@Override
	public void serialize(UserAllowList userAllowList, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, userAllowList, provider);
		
	}
}


