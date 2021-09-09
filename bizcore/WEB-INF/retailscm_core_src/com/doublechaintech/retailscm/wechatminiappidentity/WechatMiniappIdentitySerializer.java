package com.doublechaintech.retailscm.wechatminiappidentity;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class WechatMiniappIdentitySerializer extends RetailscmObjectPlainCustomSerializer<WechatMiniappIdentity>{

	@Override
	public void serialize(WechatMiniappIdentity wechatMiniappIdentity, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, wechatMiniappIdentity, provider);
		
	}
}


