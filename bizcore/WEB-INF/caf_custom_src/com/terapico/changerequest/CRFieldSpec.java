package com.terapico.changerequest;

public class CRFieldSpec {
  public static final String NOT_SELECTABLE = "not_selectable";
  public static final String SINGLE_SELECTABLE = "single_selectable";
  public static final String MULTI_SELECTABLE = "multi_selectable";

  protected String label; // ="姓名|年龄|出生地|国籍"
  protected String localeKey; // ="name|age|birth_place|country"
  protected String name; // ="name"
  protected Object value;
  protected String interactionMode;
  protected String selectable;
  protected String
      type; // ="text|longtext|date|date_time|money|url|image|password|number|switch|vcode"
  protected String placeholder; // ="姓名就是你身份证上的名字"
  protected Object defaultValue; // ="李一一"
  protected String tipsTitle; // ="?"
  protected String tipsContent; // ="姓名就是你身份证上的名字"
  protected String fieldGroup; // ="基础信息|扩展信息"
  protected String minimum; // ="maybe any value"
  protected String maximum; // ="a value expression"
  protected Boolean required; // ="true|false"
  protected Object candidateValues; // ="|||男,女|高,矮"
  protected String icon;
  protected String valuesRetrieveApi;
  protected String modelName;
  protected String uiStyle;
  protected String regExp;

  public String getUiStyle() {
    return uiStyle;
  }

  public void setUiStyle(String uiStyle) {
    this.uiStyle = uiStyle;
  }

  public String getRegExp() {
    return regExp;
  }

  public void setRegExp(String regExp) {
    this.regExp = regExp;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getLocaleKey() {
    return localeKey;
  }

  public void setLocaleKey(String localeKey) {
    this.localeKey = localeKey;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPlaceholder() {
    return placeholder;
  }

  public void setPlaceholder(String placeholder) {
    this.placeholder = placeholder;
  }

  public Object getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(Object defaultValue) {
    this.defaultValue = defaultValue;
  }

  public String getTipsTitle() {
    return tipsTitle;
  }

  public void setTipsTitle(String tipsTitle) {
    this.tipsTitle = tipsTitle;
  }

  public String getTipsContent() {
    return tipsContent;
  }

  public void setTipsContent(String tipsContent) {
    this.tipsContent = tipsContent;
  }

  public String getFieldGroup() {
    return fieldGroup;
  }

  public void setFieldGroup(String fieldGroup) {
    this.fieldGroup = fieldGroup;
  }

  public String getMinimum() {
    return minimum;
  }

  public void setMinimum(String minimum) {
    this.minimum = minimum;
  }

  public String getMaximum() {
    return maximum;
  }

  public void setMaximum(String maximum) {
    this.maximum = maximum;
  }

  public Boolean getRequired() {
    return required;
  }

  public void setRequired(Boolean required) {
    this.required = required;
  }

  public Object getCandidateValues() {
    return candidateValues;
  }

  public void setCandidateValues(Object candidateValues) {
    this.candidateValues = candidateValues;
  }

  public String getInteractionMode() {
    return interactionMode;
  }

  public void setInteractionMode(String interactionMode) {
    this.interactionMode = interactionMode;
  }

  public String getSelectable() {
    return selectable;
  }

  public void setSelectable(String selectable) {
    this.selectable = selectable;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getValuesRetrieveApi() {
    return valuesRetrieveApi;
  }

  public void setValuesRetrieveApi(String valuesRetrieveApi) {
    this.valuesRetrieveApi = valuesRetrieveApi;
  }
}
