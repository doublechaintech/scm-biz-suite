package com.doublechaintech.retailscm;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public abstract class BaseJsonSerializer<T extends BaseEntity> extends JsonSerializer<T> {

  protected void writeStringField(JsonGenerator jgen, String fieldName, String value)
      throws IOException {
    if (value == null) {
      return;
    }
    jgen.writeStringField(fieldName, value);
  }

  protected void writeNumberField(JsonGenerator jgen, String fieldName, int value)
      throws IOException {
    jgen.writeNumberField(fieldName, value);
  }

  protected void writeNumberField(JsonGenerator jgen, String fieldName, long value)
      throws IOException {
    jgen.writeNumberField(fieldName, value);
  }

  protected void writeNumberField(JsonGenerator jgen, String fieldName, float value)
      throws IOException {
    jgen.writeNumberField(fieldName, value);
  }

  protected void writeNumberField(JsonGenerator jgen, String fieldName, BigDecimal value)
      throws IOException {
    jgen.writeNumberField(fieldName, value);
  }

  protected <E extends BaseEntity> void writeCountOfList(
      JsonGenerator jgen, String fieldName, SmartList<E> list) throws IOException {

    if (list == null) {
      return;
    }
    if (list.getTotalCount() <= 0) {
      return;
    }

    jgen.writeNumberField(fieldName, list.getTotalCount());
  }

  protected <E extends BaseEntity> void writeCurrentPageOfList(
      JsonGenerator jgen, String fieldName, SmartList<E> list) throws IOException {

    if (list == null) {
      return;
    }
    if (list.getCurrentPageNumber() <= 0) {
      return;
    }

    jgen.writeNumberField(fieldName, list.getCurrentPageNumber());
  }

  protected void writeNumberField(JsonGenerator jgen, String fieldName, double value)
      throws IOException {
    jgen.writeNumberField(fieldName, value);
  }

  protected void writeBooleanField(JsonGenerator jgen, String fieldName, boolean value)
      throws IOException {
    jgen.writeBooleanField(fieldName, value);
  }

  protected void writeDateField(JsonGenerator jgen, String fieldName, Date value)
      throws IOException {
    if (value == null) {
      return;
    }
    this.writeNumberField(jgen, fieldName, value.getTime());
    ;
  }

  protected void writeDateTimeField(JsonGenerator jgen, String fieldName, Date value)
      throws IOException {
    if (value == null) {
      return;
    }
    // jgen.writeObjectField(fieldName, value);
    this.writeNumberField(jgen, fieldName, value.getTime());
    ;
  }

  @Override
  public void serialize(
      BaseEntity baseEntity, JsonGenerator jgen, SerializerProvider serialierProvider)
      throws IOException, JsonProcessingException {
    // the method must stay here for compiling
  }

  private static final String CLASS = "class";

  protected void writeStartObject(
      BaseEntity baseEntity, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {
    jgen.writeStartObject();
    writeClassField(CLASS, baseEntity, jgen, provider);
    this.writeStringField(jgen, "displayName", baseEntity.getDisplayName());
  }

  protected void writeEndObject(
      BaseEntity baseEntity, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {

    // writeActionList(ACTION_LIST,baseEntity,jgen,provider);
    // writeMessageList(MESSAGE_LIST,baseEntity,jgen,provider);
    jgen.writeEndObject();
  }

  protected void writeClassField(
      String fieldName, BaseEntity baseEntity, JsonGenerator jgen, SerializerProvider provider)
      throws IOException, JsonProcessingException {

    if (baseEntity == null) {
      return; // do nothing when base entity is null
    }

    jgen.writeStringField(fieldName, baseEntity.getClass().getName());
  }

  protected void writeClassField(String fieldName, BaseEntity baseEntity, JsonGenerator jgen)
      throws IOException, JsonProcessingException {

    if (baseEntity == null) {
      return; // do nothing when base entity is null
    }

    jgen.writeStringField(fieldName, baseEntity.getClass().getName());
  }

  protected void writeList(
      JsonGenerator jgen,
      BaseEntity container,
      String fieldName,
      SmartList<? extends BaseEntity> targetEntityList,
      SerializerProvider provider,
      Map<String, Object> serializeCtx)
      throws IOException {

    if (targetEntityList == null) {
      return;
    }

    if (targetEntityList.isEmpty()) {
      return;
    }
    if (fieldName != null && !fieldName.isEmpty()) {
      jgen.writeFieldName(fieldName);
    }
    jgen.writeStartArray();

    if (!isUp(serializeCtx)) {
      for (BaseEntity entity : targetEntityList) {
        setDown(serializeCtx);
        this.writeBaseEntityField(jgen, null, entity, provider, serializeCtx);
        back(serializeCtx);
      }
    }
    jgen.writeEndArray();
  }

  private void setUp(Map<String, Object> pSerializeCtx) {
    ensureDirections(pSerializeCtx).push("up");
  }

  private void setDown(Map<String, Object> pSerializeCtx) {
    ensureDirections(pSerializeCtx).push("down");
  }

  private void back(Map<String, Object> pSerializeCtx) {
    ensureDirections(pSerializeCtx).pop();
  }

  private boolean isUp(Map<String, Object> pSerializeCtx) {
    return "up".equals(getDirection(pSerializeCtx));
  }

  private boolean isDown(Map<String, Object> pSerializeCtx) {
    return "down".equals(getDirection(pSerializeCtx));
  }

  private String getDirection(Map<String, Object> pSerializeCtx) {
    Stack<String> s = ensureDirections(pSerializeCtx);
    if (s.isEmpty()) {
      return null;
    }
    return s.peek();
  }

  private Stack<String> ensureDirections(Map<String, Object> pSerializeCtx) {
    Stack<String> s = (Stack<String>) pSerializeCtx.get("directions");
    if (s == null) {
      s = new Stack();
      pSerializeCtx.put("directions", s);
    }
    return s;
  }

  protected void writeBaseEntityField(
      JsonGenerator jgen,
      String fieldName,
      BaseEntity baseEntity,
      SerializerProvider provider,
      Map<String, Object> ctx)
      throws IOException {

    if (baseEntity == null) {
      return;
    }

    if (fieldName != null && !fieldName.isEmpty()) {
      jgen.writeFieldName(fieldName);
    }
    extractFields(jgen, fieldName, baseEntity, provider, ctx);
  }

  protected void extractFields(
      JsonGenerator jgen,
      String fieldName,
      BaseEntity baseEntity,
      SerializerProvider provider,
      Map ctx)
      throws IOException, JsonProcessingException {
    List<KeyValuePair> pairs = baseEntity.keyValuePairOf();
    writeStartObject(baseEntity, jgen, provider);
    for (KeyValuePair pair : pairs) {
      this.writeField(jgen, baseEntity, pair.getKey(), pair.getValue(), provider, ctx);
    }
    writeEndObject(baseEntity, jgen, provider);
  }

  protected void writeField(
      JsonGenerator jgen,
      BaseEntity container,
      String fieldName,
      Object value,
      SerializerProvider provider,
      Map serializeCtx)
      throws IOException {

    if (value == null) {
      return;
    }

    if (value instanceof String) {
      this.writeStringField(jgen, fieldName, (String) value);
      return;
    }
    if (value instanceof BigDecimal) {
      this.writeNumberField(jgen, fieldName, (BigDecimal) value);
      return;
    }
    if (value instanceof Integer) {
      this.writeNumberField(jgen, fieldName, (Integer) value);
      return;
    }
    if (value instanceof Float) {
      this.writeNumberField(jgen, fieldName, (Float) value);
      return;
    }
    if (value instanceof Double) {
      this.writeNumberField(jgen, fieldName, (Double) value);
      return;
    }
    if (value instanceof Long) {
      this.writeNumberField(jgen, fieldName, (Long) value);
      return;
    }
    if (value instanceof Boolean) {
      this.writeBooleanField(jgen, fieldName, (Boolean) value);
      return;
    }
    if (value instanceof SmartList) {
      SmartList<? extends BaseEntity> targetEntityList = (SmartList<? extends BaseEntity>) value;
      this.writeBaseEntityField(
          jgen, fieldName + "MetaInfo", targetEntityList.getMetaInfo(), provider, serializeCtx);

      if (targetEntityList.isEmpty()) {
        return;
      }

      this.writeList(jgen, container, fieldName, targetEntityList, provider, serializeCtx);
      // this.writeObjectField(jgen, fieldName+"StatsInfo", targetEntityList.getStatsInfo());
      jgen.writeObjectField(fieldName + "StatsInfo", targetEntityList.getStatsInfo());
      // System.out.println("--------------------size: " + targetEntityList.size());
      return;
    }
    if (value instanceof BaseEntity) {
      setUp(serializeCtx);
      this.writeBaseEntityField(jgen, fieldName, (BaseEntity) value, provider, serializeCtx);
      back(serializeCtx);
      return;
    }

    if (value instanceof Object) {
      jgen.writeObjectField(fieldName, value);
      return;
    }
    // going to here is impossible in java :)

    throw new IllegalArgumentException(
        "The type of " + value.getClass().getName() + " is not handled by writeField");
  }
}
