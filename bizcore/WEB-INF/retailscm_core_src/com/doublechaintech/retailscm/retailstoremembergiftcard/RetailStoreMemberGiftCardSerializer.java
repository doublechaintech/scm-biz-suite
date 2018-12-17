package com.doublechaintech.retailscm.retailstoremembergiftcard;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreMemberGiftCardSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreMemberGiftCard>{

	@Override
	public void serialize(RetailStoreMemberGiftCard retailStoreMemberGiftCard, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreMemberGiftCard, provider);
		
	}
}


