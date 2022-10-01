package com.doublechaintech.retailscm.accountingdocumentline;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.doublechaintech.retailscm.RetailscmObjectPlainCustomSerializer;

public class AccountingDocumentLineSerializer
    extends RetailscmObjectPlainCustomSerializer<AccountingDocumentLine> {

  @Override
  public void serialize(
      AccountingDocumentLine accountingDocumentLine,
      JsonGenerator jgen,
      SerializerProvider provider)
      throws IOException, JsonProcessingException {
    Map<String, Object> ctx = new HashMap<>();
    this.writeBaseEntityField(jgen, null, accountingDocumentLine, provider, ctx);
  }
}
