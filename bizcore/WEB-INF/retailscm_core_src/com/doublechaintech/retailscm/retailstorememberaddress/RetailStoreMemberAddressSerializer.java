package com.doublechaintech.retailscm.retailstorememberaddress;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreMemberAddressSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreMemberAddress>{

	@Override
	public void serialize(RetailStoreMemberAddress retailStoreMemberAddress, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreMemberAddress, provider);
		
	}
}


