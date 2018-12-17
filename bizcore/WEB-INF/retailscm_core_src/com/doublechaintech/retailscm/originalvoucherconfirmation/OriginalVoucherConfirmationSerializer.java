package com.doublechaintech.retailscm.originalvoucherconfirmation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class OriginalVoucherConfirmationSerializer extends RetailscmObjectPlainCustomSerializer<OriginalVoucherConfirmation>{

	@Override
	public void serialize(OriginalVoucherConfirmation originalVoucherConfirmation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, originalVoucherConfirmation, provider);
		
	}
}


