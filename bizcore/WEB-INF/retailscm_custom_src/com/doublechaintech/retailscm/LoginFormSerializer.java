package com.doublechaintech.retailscm;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LoginFormSerializer extends JsonSerializer<LoginForm> {

  protected void writeClassField(String fieldName, BaseEntity baseEntity, JsonGenerator jgen)
      throws IOException, JsonProcessingException {

    if (baseEntity == null) {
      return; // do nothing when base entity is null
    }

    jgen.writeStringField(fieldName, baseEntity.getClass().getName());
  }

  protected String getErrorMessage(LoginForm form) {
    if (form.getErrorMessageList().isEmpty()) {
      return null;
    }
    StringBuilder stringBuffer = new StringBuilder();

    for (Message message : form.getErrorMessageList()) {
      stringBuffer.append(message.getSourcePosition());
    }
    return stringBuffer.toString();
  }

  @Override
  public void serialize(LoginForm loginForm, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    jgen.writeStartObject();
    this.writeClassField("class", loginForm, jgen);
    jgen.writeStringField("errorMessage", getErrorMessage(loginForm));
    jgen.writeStringField("usernameParmeter", loginForm.getUsernameParmeter());
    jgen.writeStringField("passwordParmeter", loginForm.getPasswordParmeter());

    jgen.writeEndObject();
  }
}
