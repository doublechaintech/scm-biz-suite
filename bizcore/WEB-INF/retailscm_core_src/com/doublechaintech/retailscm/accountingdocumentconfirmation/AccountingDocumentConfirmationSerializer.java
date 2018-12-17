package com.doublechaintech.retailscm.accountingdocumentconfirmation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class AccountingDocumentConfirmationSerializer extends RetailscmObjectPlainCustomSerializer<AccountingDocumentConfirmation>{

	@Override
	public void serialize(AccountingDocumentConfirmation accountingDocumentConfirmation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingDocumentConfirmation, provider);
		
	}
}


