package com.doublechaintech.retailscm.payingoff;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class PayingOffSerializer extends RetailscmObjectPlainCustomSerializer<PayingOff>{

	@Override
	public void serialize(PayingOff payingOff, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, payingOff, provider);
		
	}
}


