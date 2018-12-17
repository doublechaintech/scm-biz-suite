package com.doublechaintech.retailscm.supplyorderapproval;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class SupplyOrderApprovalSerializer extends RetailscmObjectPlainCustomSerializer<SupplyOrderApproval>{

	@Override
	public void serialize(SupplyOrderApproval supplyOrderApproval, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, supplyOrderApproval, provider);
		
	}
}


