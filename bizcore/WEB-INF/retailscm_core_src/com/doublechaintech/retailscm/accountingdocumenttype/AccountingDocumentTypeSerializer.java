package com.doublechaintech.retailscm.accountingdocumenttype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class AccountingDocumentTypeSerializer extends RetailscmObjectPlainCustomSerializer<AccountingDocumentType>{

	@Override
	public void serialize(AccountingDocumentType accountingDocumentType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingDocumentType, provider);
		
	}
}


