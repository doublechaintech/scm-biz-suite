package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class RetailStoreOrderPaymentGroupSerializer
    extends RetailscmObjectPlainCustomSerializer<RetailStoreOrderPaymentGroup> {

  @Override
  public void serialize(
      RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,
      JsonGenerator jgen,
      SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, retailStoreOrderPaymentGroup, provider, ctx);
  }
}
