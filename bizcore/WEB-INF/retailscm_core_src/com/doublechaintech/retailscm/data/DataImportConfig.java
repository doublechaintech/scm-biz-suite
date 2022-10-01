package com.doublechaintech.retailscm.data;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.BaseEntityUtil;
import com.terapico.caf.DateTime;
import com.terapico.utils.DateTimeUtil;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;

/** 导入数据时的配置 */
public class DataImportConfig {

  public static final String IMPORT_MODEL_INSERT = "insert";
  public static final String IMPORT_MODEL_UPDATE = "update";
  public static final String IMPORT_MODEL_INSERT_OR_UPDATE = "insertOrUpdate";

  // 目标类型
  private Class<? extends BaseEntity> targetType;

  // 属性映射
  private Map<String, String> propertyMappings = new LinkedHashMap<>();

  // 目标属性类型
  private Map<String, Class> propertyTargetTypes = new HashMap<>();

  // 类型转换
  private Map<String, PropertyConverter> propertyConverters = new HashMap<>();

  // 默认值
  private Map<String, Object> defaultPropertyValues = new HashMap<>();

  // 在导入数据前调用
  private PhaseProcessor preProcessor;

  // 在导入数据后调用
  private PhaseProcessor postProcessor;

  // 属性验证
  private Map<String, PropertyValidator[]> propertyValidators = new HashMap<>();

  // 整行的验证
  private List<RowValidator> rowValidators = new ArrayList<>();

  // 行级预处理（在解析得到行数据后调用）
  private RowPreProcessor rowPreProcessor;

  // 在更新时，用于指定哪些字段作为查询条件
  private String[] idProps;

  // 在更新时，有可以修改查询请求
  private RequestUpdater requestUpdate;

  // 指定导入数据的模式
  private String importModel = IMPORT_MODEL_INSERT;

  // 属性的中文翻译
  private Map<String, String> messages = new HashMap<>();

  // 批次大小
  private int batchSize = Integer.MAX_VALUE;

  public Class<? extends BaseEntity> getTargetType() {
    return targetType;
  }

  public Class getTargetType(String name) {
    Class type = propertyTargetTypes.get(name);
    if (type != null) {
      return type;
    }
    return BaseEntityUtil.getFieldType(getTargetType(), name);
  }

  public void setTargetType(Class<? extends BaseEntity> pTargetType) {
    targetType = pTargetType;
  }

  public Map<String, String> getPropertyMappings() {
    return propertyMappings;
  }

  public void setPropertyMappings(Map<String, String> pPropertyMappings) {
    propertyMappings = pPropertyMappings;
  }

  public Map<String, Class> getPropertyTargetTypes() {
    return propertyTargetTypes;
  }

  public void setPropertyTargetTypes(Map<String, Class> pPropertyTargetTypes) {
    propertyTargetTypes = pPropertyTargetTypes;
  }

  public Map<String, PropertyConverter> getPropertyConverters() {
    return propertyConverters;
  }

  public void setPropertyConverters(Map<String, PropertyConverter> pPropertyConverters) {
    propertyConverters = pPropertyConverters;
  }

  public Map<String, Object> getDefaultPropertyValues() {
    return defaultPropertyValues;
  }

  public void setDefaultPropertyValues(Map<String, Object> pDefaultPropertyValues) {
    defaultPropertyValues = pDefaultPropertyValues;
  }

  public PhaseProcessor getPreProcessor() {
    return preProcessor;
  }

  public void setPreProcessor(PhaseProcessor pPreProcessor) {
    preProcessor = pPreProcessor;
  }

  public PhaseProcessor getPostProcessor() {
    return postProcessor;
  }

  public void setPostProcessor(PhaseProcessor pPostProcessor) {
    postProcessor = pPostProcessor;
  }

  public int getBatchSize() {
    return batchSize;
  }

  public void setBatchSize(int pBatchSize) {
    batchSize = pBatchSize;
  }

  public Map<String, PropertyValidator[]> getPropertyValidators() {
    return propertyValidators;
  }

  public void setPropertyValidators(Map<String, PropertyValidator[]> pPropertyValidators) {
    propertyValidators = pPropertyValidators;
  }

  public void preProcess(UserContext ctx) {
    if (this.preProcessor != null) {
      this.preProcessor.process(ctx);
    }
  }

  public Map<String, String> getMessages() {
    return messages;
  }

  public void setMessages(Map<String, String> pMessages) {
    messages = pMessages;
  }

  public PropertyConverter getDataConverter(String name) {
    return propertyConverters.getOrDefault(
        name,
        (ctx, src, v, type) -> {
          if (ObjectUtil.isEmpty(v)) {
            return null;
          }

          if (type.isAssignableFrom(v.getClass())) {
            return v;
          }

          // 处理string
          if (type.equals(String.class)) {
            return String.valueOf(v);
          }

          // 处理datetime
          if (type.equals(DateTime.class)) {
            return DateTime.fromDate(DateTimeUtil.parseInputDateTime(String.valueOf(v)));
          }

          // base entity
          if (BaseEntity.class.isAssignableFrom(type)) {
            return convertToBaseEntity(ctx, String.valueOf(v), (Class<? extends BaseEntity>) type);
          }

          if (type.equals(int.class)) {
            return convertToInt(v, 0);
          }

          if (type.equals(Integer.class)) {
            return convertToInt(v, null);
          }

          if (type.equals(double.class)) {
            return convertToDouble(v, 0.0);
          }

          if (type.equals(Double.class)) {
            return convertToDouble(v, null);
          }

          if (type.equals(BigDecimal.class)) {
            return convertToBigDecimal(v, null);
          }
          throw new ErrorMessageException(String.format("未知类型%s没处理", type));
        });
  }

  private static Object convertToBigDecimal(Object value, Object defaultValue) {
    if (ObjectUtil.isEmpty(value)) {
      return defaultValue;
    }
    if (value instanceof Number) {
      return new BigDecimal(((Number) value).doubleValue());
    }
    String trim = String.valueOf(value).trim();
    if (StrUtil.isBlank(trim)) {
      return defaultValue;
    }
    try {
      return new BigDecimal(NumberUtil.parseNumber(String.valueOf(value).trim()).doubleValue());
    } catch (Exception e) {
      return defaultValue;
    }
  }

  private static Object convertToDouble(Object value, Object defaultValue) {
    if (ObjectUtil.isEmpty(value)) {
      return defaultValue;
    }
    if (value instanceof Number) {
      return ((Number) value).doubleValue();
    }
    String trim = String.valueOf(value).trim();
    if (StrUtil.isBlank(trim)) {
      return defaultValue;
    }

    try {
      return NumberUtil.parseNumber(String.valueOf(value).trim()).doubleValue();
    } catch (Exception e) {
      return defaultValue;
    }
  }

  private static Object convertToInt(Object value, Object defaultValue) {
    if (ObjectUtil.isEmpty(value)) {
      return defaultValue;
    }
    if (value instanceof Number) {
      return ((Number) value).intValue();
    }
    String trim = String.valueOf(value).trim();
    if (StrUtil.isBlank(trim)) {
      return defaultValue;
    }

    try {
      return NumberUtil.parseNumber(trim).intValue();
    } catch (Exception e) {
      return defaultValue;
    }
  }

  public static Object convertToBaseEntity(
      CustomRetailscmUserContextImpl ctx, String value, Class<? extends BaseEntity> targetType) {

    if (StrUtil.isEmpty(value)) {
      return null;
    }

    BaseEntity baseEntity = ReflectUtil.newInstance(targetType);
    Method method = ReflectUtil.getMethodByName(targetType, "updateName");
    if (method == null) {
      throw new ErrorMessageException(String.format("未知类型%s没处理", targetType));
    }
    ReflectUtil.invoke(baseEntity, method, value);
    try {
      return RetailscmBaseUtils.reload(ctx, baseEntity);
    } catch (Exception pE) {
      throw new ErrorMessageException(pE);
    }
  }

  public List<RowValidator> getRowValidators() {
    return rowValidators;
  }

  public void setRowValidators(List<RowValidator> pRowValidators) {
    rowValidators = pRowValidators;
  }

  public DataImportConfig(Class<? extends BaseEntity> pTargetType) {
    targetType = pTargetType;
  }

  public DataImportConfig map(
      String sourceName, String targetName, PropertyConverter propertyConverter) {
    propertyMappings.put(targetName, sourceName);
    propertyConverters.put(targetName, propertyConverter);
    return this;
  }

  public DataImportConfig map(
      String sourceName, String targetName, PropertyValidator... propertyValidator) {
    propertyMappings.put(targetName, sourceName);
    propertyValidators.put(targetName, propertyValidator);
    return this;
  }

  public DataImportConfig map(
      String sourceName,
      String targetName,
      PropertyConverter propertyConverter,
      PropertyValidator... propertyValidator) {
    propertyMappings.put(targetName, sourceName);
    propertyConverters.put(targetName, propertyConverter);
    propertyValidators.put(targetName, propertyValidator);
    return this;
  }

  public DataImportConfig map(
      String sourceName,
      String targetName,
      Class propertyTargetType,
      PropertyConverter propertyConverter,
      PropertyValidator... propertyValidator) {
    propertyMappings.put(targetName, sourceName);
    propertyType(targetName, propertyTargetType);
    propertyConverters.put(targetName, propertyConverter);
    propertyValidators.put(targetName, propertyValidator);
    return this;
  }

  public DataImportConfig map(
      String sourceName,
      String targetName,
      Class propertyTargetType,
      PropertyValidator... propertyValidator) {
    propertyMappings.put(targetName, sourceName);
    propertyType(targetName, propertyTargetType);
    propertyValidators.put(targetName, propertyValidator);
    return this;
  }

  public DataImportConfig propertyType(String name, Class propertyTargetType) {
    propertyTargetTypes.put(name, propertyTargetType);
    return this;
  }

  public DataImportConfig withConverter(String targetName, PropertyConverter converter) {
    propertyMappings.put(targetName, null);
    propertyConverters.put(targetName, converter);
    return this;
  }

  public DataImportConfig withRowValidator(RowValidator rowValidator) {
    this.rowValidators.add(rowValidator);
    return this;
  }

  public DataImportConfig withDefault(String property, Object value) {
    this.defaultPropertyValues.put(property, value);
    return this;
  }

  public RowPreProcessor getRowPreProcessor() {
    return rowPreProcessor;
  }

  public void setRowPreProcessor(RowPreProcessor pRowPreProcessor) {
    rowPreProcessor = pRowPreProcessor;
  }

  public String[] getIdProps() {
    return idProps;
  }

  public void setIdProps(String[] pIdProps) {
    idProps = pIdProps;
  }

  public boolean isUpdate() {
    return IMPORT_MODEL_UPDATE.equalsIgnoreCase(importModel);
  }

  public boolean isInsert() {
    return IMPORT_MODEL_INSERT.equalsIgnoreCase(importModel);
  }

  public RequestUpdater getRequestUpdate() {
    return requestUpdate;
  }

  public void setRequestUpdate(RequestUpdater pRequestUpdate) {
    requestUpdate = pRequestUpdate;
  }

  public String getImportModel() {
    return importModel;
  }

  public void setImportModel(String pImportModel) {
    importModel = pImportModel;
  }

  public boolean isInsertOrUpdate() {
    return IMPORT_MODEL_INSERT_OR_UPDATE.equalsIgnoreCase(importModel);
  }
}
