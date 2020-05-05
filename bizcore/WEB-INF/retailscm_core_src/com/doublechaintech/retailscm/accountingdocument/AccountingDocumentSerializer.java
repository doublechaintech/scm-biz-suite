package com.doublechaintech.retailscm.accountingdocument;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class AccountingDocumentSerializer extends RetailscmObjectPlainCustomSerializer<AccountingDocument>{

	@Override
	public void serialize(AccountingDocument accountingDocument, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingDocument, provider);
		
	}
}


