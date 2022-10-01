package com.doublechaintech.retailscm.retailstoremembergiftcard;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class RetailStoreMemberGiftCardSerializer
    extends RetailscmObjectPlainCustomSerializer<RetailStoreMemberGiftCard> {

  @Override
  public void serialize(
      RetailStoreMemberGiftCard retailStoreMemberGiftCard,
      JsonGenerator jgen,
      SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, retailStoreMemberGiftCard, provider, ctx);
  }
}
