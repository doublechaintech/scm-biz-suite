package com.doublechaintech.retailscm.wechatworkappidentity;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class WechatWorkappIdentitySerializer extends RetailscmObjectPlainCustomSerializer<WechatWorkappIdentity>{

	@Override
	public void serialize(WechatWorkappIdentity wechatWorkappIdentity, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, wechatWorkappIdentity, provider);
		
	}
}


