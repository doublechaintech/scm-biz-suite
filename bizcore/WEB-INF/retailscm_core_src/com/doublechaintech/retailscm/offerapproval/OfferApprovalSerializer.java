package com.doublechaintech.retailscm.offerapproval;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class OfferApprovalSerializer extends RetailscmObjectPlainCustomSerializer<OfferApproval>{

	@Override
	public void serialize(OfferApproval offerApproval, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, offerApproval, provider);
		
	}
}


