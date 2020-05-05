package com.terapico.caf.appview;

import com.terapico.utils.TextUtil;
import java.util.List;
import java.util.Map;

public class CRFieldSelector {
  protected String fieldId;
  protected String groupName;
  protected String fieldName;
  protected boolean autoCreate = false;
  protected CRFieldData fieldData = null;
  protected CRGroupData root;

  CRFieldSelector(CRGroupData groupData, String fieldId, String fieldName, boolean autoCreate) {
    this.root = groupData;
    this.fieldId = fieldId;
    this.fieldName = TextUtil.uncapFirstChar(TextUtil.toCamelCase(fieldName));
    this.autoCreate = autoCreate;
  }

  public CRFieldData get() {
    return foundFieldData();
  }

  /**
   * 搜索规则: fieldId == null, fieldName == null: ERROR. fieldId == null, fieldName != null: any
   * 'fieldName' matched; fieldId != null, fieldName != null: ID and NAME must match fieldId !=
   * null, fieldName == null: ERROR.
   *
   * @return
   */
  private CRFieldData foundFieldData() {
    if (fieldData != null) {
      return fieldData;
    }
    if (fieldName == null) {
      throw new RuntimeException("必须指定字段的名称,才能继续操作");
    }
    String searchFieldName = root.getName() + "_" + fieldName + "_";
    for (CRFieldData fieldData : root.getFieldList()) {
      if (!fieldData.getName().startsWith(searchFieldName)) {
        continue;
      }
      if (fieldId != null) {
        if (fieldData.getName().endsWith("_" + fieldId)) {
          this.fieldData = fieldData;
          return fieldData;
        }
      } else {
        this.fieldData = fieldData;
        return fieldData;
      }
    }
    // not found
    if (!autoCreate) {
      throw new RuntimeException("在" + root.getName() + "中找不到" + fieldName + "字段");
    }
    CRFieldData newData = new CRFieldData();
    newData.setName(searchFieldName + "_new");
    newData.setType("string");
    newData.setRequired(true);
    root.addField(newData);
    this.fieldData = newData;
    return newData;
  }

  protected void ensureNotAutoCreated() {
    if (this.autoCreate) {
      String methodName = new Throwable().getStackTrace()[1].getMethodName();
      throw new RuntimeException("自动创建的字段不能" + methodName + "()");
    }
  }

  public CRFieldSelector value(Object value) {
    foundFieldData().setValue(value);
    return this;
  }

  public CRFieldSelector disable() {
    ensureNotAutoCreated();
    foundFieldData().setDisabled(true);
    return this;
  }

  public CRFieldSelector enable() {
    foundFieldData().setDisabled(false);
    return this;
  }

  public CRFieldSelector hidden() {
    ensureNotAutoCreated();
    foundFieldData().setHidden(true);
    return this;
  }

  public CRFieldSelector unhidden() {
    foundFieldData().setHidden(false);
    return this;
  }

  public CRFieldSelector label(String label) {
    foundFieldData().setLabel(label);
    return this;
  }

  public CRFieldSelector placeholder(String message) {
    foundFieldData().setPlaceholder(message);
    return this;
  }

  public CRFieldSelector tips(String title, String content) {
    foundFieldData().setTipsTitle(title);
    foundFieldData().setTipsContent(content);
    return this;
  }

  public CRFieldSelector range(String minimum, String maximum) {
    foundFieldData().setMinimum(minimum);
    foundFieldData().setMaximum(maximum);
    return this;
  }

  public CRFieldSelector candidateValues(Object candidateValues) {
    foundFieldData().setCandidateValues(candidateValues);
    return this;
  }

  public CRFieldSelector multipleSelection() {
    foundFieldData().setMultiple(true);
    return this;
  }

  public CRFieldSelector singleSelection() {
    foundFieldData().setMultiple(false);
    return this;
  }

  public CRFieldSelector required() {
    ensureNotAutoCreated();
    foundFieldData().setRequired(true);
    return this;
  }

  public CRFieldSelector optional() {
    ensureNotAutoCreated();
    foundFieldData().setRequired(false);
    return this;
  }

  public CRFieldSelector rules(List<Map<String, Object>> rules) {
    foundFieldData().setRules(rules);
    return this;
  }

  public CRFieldSelector setPosition(int postion) {
    List<CRFieldData> fieldList = this.root.getFieldList();
    CRFieldData curField = foundFieldData();
    fieldList.remove(curField);
    fieldList.add(Math.min(postion, fieldList.size()), curField);
    return this;
  }

  public CRFieldSelector forDisplay() {
    foundFieldData().setType("prompt_message");
    return this;
  }
}
