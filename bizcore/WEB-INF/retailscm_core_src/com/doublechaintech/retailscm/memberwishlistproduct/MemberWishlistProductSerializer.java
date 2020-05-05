package com.doublechaintech.retailscm.memberwishlistproduct;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;
public class MemberWishlistProductSerializer extends RetailscmObjectPlainCustomSerializer<MemberWishlistProduct>{

	@Override
	public void serialize(MemberWishlistProduct memberWishlistProduct, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
			
		this.writeBaseEntityField(jgen, null, memberWishlistProduct, provider);
		
	}
}


