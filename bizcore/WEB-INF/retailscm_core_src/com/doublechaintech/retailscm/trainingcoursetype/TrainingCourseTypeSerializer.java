package com.doublechaintech.retailscm.trainingcoursetype;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class TrainingCourseTypeSerializer extends RetailscmObjectPlainCustomSerializer<TrainingCourseType>{

	@Override
	public void serialize(TrainingCourseType trainingCourseType, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, trainingCourseType, provider);
		
	}
}


