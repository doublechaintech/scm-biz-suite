package com.doublechaintech.retailscm.accountingdocumentline;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class AccountingDocumentLineSerializer extends RetailscmObjectPlainCustomSerializer<AccountingDocumentLine>{

	@Override
	public void serialize(AccountingDocumentLine accountingDocumentLine, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingDocumentLine, provider);
		
	}
}


