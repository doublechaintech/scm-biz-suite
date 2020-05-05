package com.doublechaintech.retailscm.citypartner;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class CityPartnerSerializer extends RetailscmObjectPlainCustomSerializer<CityPartner>{

	@Override
	public void serialize(CityPartner cityPartner, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, cityPartner, provider);
		
	}
}


