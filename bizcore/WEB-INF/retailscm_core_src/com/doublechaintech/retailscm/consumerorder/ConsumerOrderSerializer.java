package com.doublechaintech.retailscm.consumerorder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class ConsumerOrderSerializer extends RetailscmObjectPlainCustomSerializer<ConsumerOrder> {

  @Override
  public void serialize(
      ConsumerOrder consumerOrder, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, consumerOrder, provider, ctx);
  }
}
