package com.doublechaintech.retailscm.employeeeducation;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class EmployeeEducationSerializer extends RetailscmObjectPlainCustomSerializer<EmployeeEducation>{

	@Override
	public void serialize(EmployeeEducation employeeEducation, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeEducation, provider);
		
	}
}


