package com.doublechaintech.retailscm;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class RetailscmExceptionJsonSerializer extends JsonSerializer<RetailscmException> {

  private static final String MESSAGE = "message";

  @Override
  public void serialize(
      RetailscmException exception, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    this.writeStartObject(exception, jgen, provider);
    this.writeExceptionMessage(MESSAGE, exception, jgen, provider);
    this.writeMessageList(MESSAGE_LIST, exception, jgen, provider);
    this.writeEndObject(exception, jgen, provider);
  }

  protected void writeExceptionMessage(
      String message, RetailscmException exception, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {

    if (exception.getMessage() != null) {
      this.writeStringField(message, exception.getMessage(), jgen, provider);
    }
  }

  private static final String CLASS = "class";

  protected void writeStartObject(
      RetailscmException exception, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    jgen.writeStartObject();
    writeClassField(CLASS, exception, jgen, provider);
  }

  private static final String MESSAGE_LIST = "messageList";

  protected void writeEndObject(
      RetailscmException exception, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {

    writeMessageList(MESSAGE_LIST, exception, jgen, provider);
    jgen.writeEndObject();
  }

  protected void writeClassField(
      String fieldName,
      RetailscmException exception,
      JsonGenerator jgen,
      SerializerProvider provider)
      throws IOException, JsonProcessingException {

    if (exception == null) {
      return; // do nothing when base entity is null
    }

    jgen.writeStringField(fieldName, exception.getClass().getName());
  }

  protected void writeStringField(
      String key, String value, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {

    if (value == null) {
      return; // do nothing when base entity is null
    }
    jgen.writeStringField(key, value);
  }

  protected void writeMessageList(
      String fieldName,
      RetailscmException exception,
      JsonGenerator jgen,
      SerializerProvider provider)
      throws IOException, JsonProcessingException {
    if (exception == null) {
      return; // do nothing when base entity is null
    }

    List<Message> messageList = exception.getErrorMessageList();

    if (messageList == null) {
      return; // do nothing when null found for this field.
    }
    if (messageList.isEmpty()) {
      return; // do nothing when no elements found for this field.
    }
    jgen.writeFieldName(fieldName);
    jgen.writeStartArray();
    // start an array [
    for (Message message : messageList) {

      jgen.writeStartObject(); // {

      jgen.writeStringField("level", message.getLevel());
      jgen.writeStringField("body", message.getBody());
      jgen.writeStringField("sourcePosition", message.getSourcePosition());

      jgen.writeEndObject(); //
    }
    jgen.writeEndArray();
    // end the array ]
  }
}
