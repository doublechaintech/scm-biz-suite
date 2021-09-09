package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreInvestmentInvitationSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreInvestmentInvitation>{

	@Override
	public void serialize(RetailStoreInvestmentInvitation retailStoreInvestmentInvitation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreInvestmentInvitation, provider);
		
	}
}


