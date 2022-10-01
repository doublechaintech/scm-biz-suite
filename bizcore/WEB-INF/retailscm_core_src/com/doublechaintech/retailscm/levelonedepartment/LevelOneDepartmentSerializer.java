package com.doublechaintech.retailscm.levelonedepartment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class LevelOneDepartmentSerializer
    extends RetailscmObjectPlainCustomSerializer<LevelOneDepartment> {

  @Override
  public void serialize(
      LevelOneDepartment levelOneDepartment, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, levelOneDepartment, provider, ctx);
  }
}
