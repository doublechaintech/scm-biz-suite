package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class RetailStoreMemberGiftCardConsumeRecordSerializer
    extends RetailscmObjectPlainCustomSerializer<RetailStoreMemberGiftCardConsumeRecord> {

  @Override
  public void serialize(
      RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord,
      JsonGenerator jgen,
      SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, retailStoreMemberGiftCardConsumeRecord, provider, ctx);
  }
}
