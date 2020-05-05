package com.doublechaintech.retailscm.accountingsubject;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class AccountingSubjectSerializer extends RetailscmObjectPlainCustomSerializer<AccountingSubject>{

	@Override
	public void serialize(AccountingSubject accountingSubject, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, accountingSubject, provider);
		
	}
}


