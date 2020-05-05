package com.doublechaintech.retailscm.memberrewardpointredemption;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class MemberRewardPointRedemptionSerializer extends RetailscmObjectPlainCustomSerializer<MemberRewardPointRedemption>{

	@Override
	public void serialize(MemberRewardPointRedemption memberRewardPointRedemption, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, memberRewardPointRedemption, provider);
		
	}
}


