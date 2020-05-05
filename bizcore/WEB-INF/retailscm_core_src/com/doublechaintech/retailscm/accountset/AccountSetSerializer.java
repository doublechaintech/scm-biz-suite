package com.doublechaintech.retailscm.accountset;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class AccountSetSerializer extends RetailscmObjectPlainCustomSerializer<AccountSet>{

	@Override
	public void serialize(AccountSet accountSet, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountSet, provider);
		
	}
}


