package com.doublechaintech.retailscm.originalvoucherauditing;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class OriginalVoucherAuditingSerializer extends RetailscmObjectPlainCustomSerializer<OriginalVoucherAuditing>{

	@Override
	public void serialize(OriginalVoucherAuditing originalVoucherAuditing, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, originalVoucherAuditing, provider);
		
	}
}


