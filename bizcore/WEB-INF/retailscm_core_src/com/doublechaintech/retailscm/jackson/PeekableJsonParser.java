package com.doublechaintech.retailscm.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.JsonParserDelegate;

import java.io.IOException;

public class PeekableJsonParser extends JsonParserDelegate {

  private JsonToken lookAhead = null;

  public PeekableJsonParser(JsonParser d) {
    super(d);
  }

  @Override
  public JsonToken nextToken() throws IOException {
    if (lookAhead != null) {
      JsonToken t = lookAhead;
      lookAhead = null;
      return t;
    }
    return super.nextToken();
  }

  public JsonToken peek() throws IOException {
    if (lookAhead != null) {
      return lookAhead;
    }
    JsonToken jsonToken = super.nextToken();
    lookAhead = jsonToken;
    return lookAhead;
  }
}
