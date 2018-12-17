package com.doublechaintech.retailscm.retailstoremembercoupon;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class RetailStoreMemberCouponSerializer extends RetailscmObjectPlainCustomSerializer<RetailStoreMemberCoupon>{

	@Override
	public void serialize(RetailStoreMemberCoupon retailStoreMemberCoupon, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, retailStoreMemberCoupon, provider);
		
	}
}


