package com.doublechaintech.retailscm.leavetype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class LeaveTypeSerializer extends RetailscmObjectPlainCustomSerializer<LeaveType>{

	@Override
	public void serialize(LeaveType leaveType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, leaveType, provider);
		
	}
}


