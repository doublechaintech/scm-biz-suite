package com.doublechaintech.retailscm.employeeboarding;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class EmployeeBoardingSerializer extends RetailscmObjectPlainCustomSerializer<EmployeeBoarding>{

	@Override
	public void serialize(EmployeeBoarding employeeBoarding, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, employeeBoarding, provider);
		
	}
}


