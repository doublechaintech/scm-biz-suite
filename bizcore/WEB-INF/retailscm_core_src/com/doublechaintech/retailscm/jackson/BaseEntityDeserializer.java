package com.doublechaintech.retailscm.jackson;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.ZipUtil;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.terapico.caf.DateTime;
import com.terapico.utils.DateTimeUtil;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.doublechaintech.retailscm.jackson.BaseEntitySerializer.*;

public class BaseEntityDeserializer {

  public static <T extends BaseEntity> T deserialize(String base64EncodedJson) {
    byte[] decode = Base64.decode(base64EncodedJson);
    String json = ZipUtil.unGzip(decode, CharsetUtil.UTF_8);
    Map<Long, BaseEntity> objs = new HashMap<>();
    try {
      JsonParser jsonParser = new JsonFactory().createParser(new StringReader(json));
      return (T) parse(new PeekableJsonParser(jsonParser), objs);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private static BaseEntity parse(PeekableJsonParser pJsonParser, Map<Long, BaseEntity> pObjs)
      throws IOException {
    JsonToken jsonToken = pJsonParser.peek();
    if (JsonToken.VALUE_NULL == jsonToken) {
      return parseAsNull(pJsonParser);
    }

    if (JsonToken.START_OBJECT == jsonToken) {
      return parseAsObj(pJsonParser, pObjs);
    }

    if (JsonToken.VALUE_NUMBER_INT == jsonToken) {
      return pObjs.get(pJsonParser.nextLongValue(0));
    }
    // error
    return null;
  }

  private static BaseEntity parseAsObj(PeekableJsonParser pJsonParser, Map<Long, BaseEntity> pObjs)
      throws IOException {
    assertTokenType(pJsonParser, JsonToken.START_OBJECT);
    assertFieldName(pJsonParser, CLASS);
    String className = nextStringValue(pJsonParser);
    BaseEntity ret = ReflectUtil.newInstance(className);

    assertFieldName(pJsonParser, OBJ_ID);
    pObjs.put(nextLongValue(pJsonParser), ret);

    // list的情况
    if (ret instanceof SmartList) {
      parseList(pJsonParser, pObjs, (SmartList) ret);
    }

    // 字段设置
    while (pJsonParser.peek() != JsonToken.END_OBJECT) {
      String property = nextFieldName(pJsonParser);
      Object value = parseValue(ret, property, pJsonParser, pObjs);
      ReflectUtil.invoke(ret, "set" + StrUtil.upperFirst(property), value);
    }
    assertTokenType(pJsonParser, JsonToken.END_OBJECT);
    return ret;
  }

  private static Object parseValue(
      BaseEntity ret, String property, PeekableJsonParser jsonParser, Map<Long, BaseEntity> objs)
      throws IOException {
    Class clazz = inspectType(ret, property);
    if (BaseEntity.class.isAssignableFrom(clazz)) {
      if (jsonParser.peek() == JsonToken.VALUE_NUMBER_INT) {
        return objs.get(nextLongValue(jsonParser));
      } else {
        return parse(jsonParser, objs);
      }
    }

    if (String.class.equals(clazz)) {
      return nextStringValue(jsonParser);
    }

    if (int.class.equals(clazz)) {
      return nextIntValue(jsonParser);
    }

    if (long.class.equals(clazz)) {
      return nextLongValue(jsonParser);
    }

    if (float.class.equals(clazz)) {
      return nextFloatValue(jsonParser);
    }

    if (double.class.equals(clazz)) {
      return nextFloatValue(jsonParser);
    }

    if (DateTime.class.equals(clazz)) {
      return DateTime.fromDate(DateTimeUtil.parseInputDateTime(nextStringValue(jsonParser)));
    }

    if (BigDecimal.class.equals(clazz)) {
      return new BigDecimal(nextFloatValue(jsonParser));
    }

    if (Boolean.class.equals(clazz) || boolean.class.equals(clazz)) {
      return nextBooleanValue(jsonParser);
    }
    error(jsonParser, "unsupported type:" + clazz);
    return null;
  }

  private static Object nextBooleanValue(PeekableJsonParser parser) throws IOException {
    parser.nextToken();
    return parser.getValueAsBoolean();
  }

  private static double nextFloatValue(PeekableJsonParser parser) throws IOException {
    parser.nextToken();
    return parser.getValueAsDouble();
  }

  private static Class inspectType(BaseEntity pRet, String pProperty) {
    Method methodByName =
        ReflectUtil.getMethodByName(pRet.getClass(), "get" + StrUtil.upperFirst(pProperty));
    return methodByName.getReturnType();
  }

  private static void error(JsonParser parser, String format, Object... parameters)
      throws JsonParseException {
    throw new JsonParseException(parser, "解析错语:" + String.format(format, parameters));
  }

  private static void assertFieldName(PeekableJsonParser pJsonParser, String fieldName)
      throws IOException {
    JsonToken jsonToken = pJsonParser.nextToken();
    if (jsonToken != JsonToken.FIELD_NAME) {
      throw new JsonParseException(pJsonParser, "json 解析错语，期望是字段名称,实际是" + jsonToken);
    }
    String text = pJsonParser.getText();
    if (!fieldName.equals(text)) {
      throw new JsonParseException(pJsonParser, "json 解析错语，期望字段名称是" + fieldName + ",实际是" + text);
    }
  }

  private static void assertTokenType(PeekableJsonParser pJsonParser, JsonToken expectToken)
      throws IOException {
    JsonToken jsonToken = pJsonParser.nextToken();
    if (jsonToken != expectToken) {
      throw new JsonParseException(pJsonParser, "json 解析错语，期望是" + expectToken + ",实际是" + jsonToken);
    }
  }

  private static BaseEntity parseAsNull(PeekableJsonParser pJsonParser) throws IOException {
    pJsonParser.nextToken();
    return null;
  }

  private static void parseList(
      PeekableJsonParser pJsonParser, Map<Long, BaseEntity> pObjs, SmartList pEntity)
      throws IOException {
    assertFieldName(pJsonParser, DATA);
    assertTokenType(pJsonParser, JsonToken.START_ARRAY);
    while (pJsonParser.peek() != JsonToken.END_ARRAY) {
      BaseEntity parse = parse(pJsonParser, pObjs);
      pEntity.add(parse);
    }
    assertTokenType(pJsonParser, JsonToken.END_ARRAY);
  }

  private static String nextFieldName(PeekableJsonParser parser) throws IOException {
    assertTokenType(parser, JsonToken.FIELD_NAME);
    return parser.getCurrentName();
  }

  private static String nextStringValue(PeekableJsonParser parser) throws IOException {
    assertTokenType(parser, JsonToken.VALUE_STRING);
    return parser.getText();
  }

  private static int nextIntValue(PeekableJsonParser parser) throws IOException {
    assertTokenType(parser, JsonToken.VALUE_NUMBER_INT);
    return parser.getValueAsInt();
  }

  private static Long nextLongValue(PeekableJsonParser parser) throws IOException {
    assertTokenType(parser, JsonToken.VALUE_NUMBER_INT);
    return parser.getLongValue();
  }
}
