package com.doublechaintech.retailscm.accountingdocumentcreation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class AccountingDocumentCreationSerializer extends RetailscmObjectPlainCustomSerializer<AccountingDocumentCreation>{

	@Override
	public void serialize(AccountingDocumentCreation accountingDocumentCreation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingDocumentCreation, provider);
		
	}
}


