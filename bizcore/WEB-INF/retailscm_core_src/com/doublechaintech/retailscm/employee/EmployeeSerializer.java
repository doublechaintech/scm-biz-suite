package com.doublechaintech.retailscm.employee;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class EmployeeSerializer extends RetailscmObjectPlainCustomSerializer<Employee>{

	@Override
	public void serialize(Employee employee, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employee, provider);
		
	}
}


