package com.doublechaintech.retailscm.jackson;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.terapico.caf.DateTime;
import com.terapico.utils.DateTimeUtil;

import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class BaseEntitySerializer {
  public static final String CLASS = "$class";
  public static final String OBJ_REF = "$objRef";
  public static final String OBJ_ID = "$objId";
  public static final String DATA = "$data";

  public static String toString(BaseEntity pBaseEntity) {
    JsonFactory factory = new JsonFactory();
    StringWriter w = new StringWriter();
    try (JsonGenerator generator = factory.createGenerator(w)) {
      serialize(pBaseEntity, generator);
    } catch (IOException pE) {
      pE.printStackTrace();
    }
    return Base64.encode(ZipUtil.gzip(w.toString(), CharsetUtil.UTF_8));
  }

  public static void serialize(BaseEntity pBaseEntity, JsonGenerator pJsonGenerator)
      throws IOException {
    Map<ObjWrapper, Long> objectRefer = new HashMap<>();
    doSerialize(pBaseEntity, pJsonGenerator, objectRefer, new AtomicLong(0));
  }

  private static void doSerialize(
      BaseEntity pBaseEntity,
      JsonGenerator jgen,
      Map<ObjWrapper, Long> objectRefer,
      AtomicLong objIndex)
      throws IOException {

    if (pBaseEntity == null) {
      jgen.writeNull();
      return;
    }

    ObjWrapper entityWrapper = new ObjWrapper(pBaseEntity);
    if (objectRefer.containsKey(entityWrapper)) {
      jgen.writeNumber(objectRefer.get(entityWrapper));
      return;
    }

    jgen.writeStartObject();
    jgen.writeStringField(CLASS, pBaseEntity.getClass().getName());
    long objId = objIndex.incrementAndGet();
    objectRefer.put(entityWrapper, objId);
    jgen.writeNumberField(OBJ_ID, objId);

    if (pBaseEntity instanceof SmartList) {
      jgen.writeArrayFieldStart(DATA);
      for (BaseEntity baseEntity : ((SmartList<?>) pBaseEntity)) {
        doSerialize(baseEntity, jgen, objectRefer, objIndex);
      }
      jgen.writeEndArray();
      jgen.writeEndObject();
      return;
    }

    String[] propertyNames = pBaseEntity.getPropertyNames();
    if (propertyNames != null) {
      for (String propertyName : propertyNames) {
        Object o = pBaseEntity.propertyOf(propertyName);
        if (o == null) {
          // jgen.writeNullField(propertyName);
          continue;
        }

        if (o instanceof BaseEntity) {
          jgen.writeFieldName(propertyName);
          doSerialize((BaseEntity) o, jgen, objectRefer, objIndex);
          continue;
        }
        writeField(jgen, propertyName, o);
      }
    }

    Set<String> referProperties = pBaseEntity.getReferProperties().keySet();
    if (referProperties != null) {
      for (String referProperty : referProperties) {
        BaseEntity value =
            ReflectUtil.invoke(pBaseEntity, "get" + StrUtil.upperFirst(referProperty));

        if (value == null || value.isEmpty()) {
          continue;
        }
        jgen.writeFieldName(referProperty);
        doSerialize(value, jgen, objectRefer, objIndex);
      }
    }
    jgen.writeEndObject();
  }

  private static void writeField(JsonGenerator jgen, String fieldName, Object value)
      throws IOException {

    if (value == null) {
      return;
    }

    if (value instanceof String) {
      jgen.writeStringField(fieldName, (String) value);
      return;
    }
    if (value instanceof BigDecimal) {
      jgen.writeNumberField(fieldName, (BigDecimal) value);
      return;
    }
    if (value instanceof Integer) {
      jgen.writeNumberField(fieldName, (Integer) value);
      return;
    }
    if (value instanceof Float) {
      jgen.writeNumberField(fieldName, (Float) value);
      return;
    }
    if (value instanceof Double) {
      jgen.writeNumberField(fieldName, (Double) value);
      return;
    }
    if (value instanceof Long) {
      jgen.writeNumberField(fieldName, (Long) value);
      return;
    }
    if (value instanceof Boolean) {
      jgen.writeBooleanField(fieldName, (Boolean) value);
      return;
    }

    if (value instanceof DateTime) {
      jgen.writeStringField(
          fieldName, DateTimeUtil.formatDate((Date) value, "yyyy-MM-dd HH:mm:ss"));
      return;
    }

    if (value instanceof Object) {
      jgen.writeObjectField(fieldName, value);
      return;
    }
  }

  static class ObjWrapper {
    private Object obj;

    public ObjWrapper(Object obj) {
      this.obj = obj;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof ObjWrapper) {
        return this.obj == ((ObjWrapper) obj).obj;
      }
      return false;
    }

    @Override
    public int hashCode() {
      return Objects.hash(obj);
    }
  }
}
