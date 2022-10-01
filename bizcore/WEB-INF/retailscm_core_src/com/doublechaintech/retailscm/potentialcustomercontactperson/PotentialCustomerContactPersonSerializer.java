package com.doublechaintech.retailscm.potentialcustomercontactperson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class PotentialCustomerContactPersonSerializer
    extends RetailscmObjectPlainCustomSerializer<PotentialCustomerContactPerson> {

  @Override
  public void serialize(
      PotentialCustomerContactPerson potentialCustomerContactPerson,
      JsonGenerator jgen,
      SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, potentialCustomerContactPerson, provider, ctx);
  }
}
