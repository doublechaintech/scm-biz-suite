package com.doublechaintech.retailscm.responsibilitytype;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class ResponsibilityTypeSerializer
    extends RetailscmObjectPlainCustomSerializer<ResponsibilityType> {

  @Override
  public void serialize(
      ResponsibilityType responsibilityType, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, responsibilityType, provider, ctx);
  }
}
