package com.doublechaintech.retailscm.retailstoreorderlineitem;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class RetailStoreOrderLineItemSerializer
    extends RetailscmObjectPlainCustomSerializer<RetailStoreOrderLineItem> {

  @Override
  public void serialize(
      RetailStoreOrderLineItem retailStoreOrderLineItem,
      JsonGenerator jgen,
      SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, retailStoreOrderLineItem, provider, ctx);
  }
}
