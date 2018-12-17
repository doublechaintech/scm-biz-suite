package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreMemberGiftCardConsumeRecordSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreMemberGiftCardConsumeRecord>{

	@Override
	public void serialize(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreMemberGiftCardConsumeRecord, provider);
		
	}
}


