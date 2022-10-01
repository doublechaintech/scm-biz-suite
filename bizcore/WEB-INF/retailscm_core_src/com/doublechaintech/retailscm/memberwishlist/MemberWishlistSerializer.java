package com.doublechaintech.retailscm.memberwishlist;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class MemberWishlistSerializer extends RetailscmObjectPlainCustomSerializer<MemberWishlist> {

  @Override
  public void serialize(
      MemberWishlist memberWishlist, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, memberWishlist, provider, ctx);
  }
}
