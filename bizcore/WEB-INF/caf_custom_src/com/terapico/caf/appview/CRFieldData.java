package com.terapico.caf.appview;

import java.util.List;
import java.util.Map;

public class CRFieldData {
  protected String
      name; // : person_info.male.name          // 前台直接使用，不需要解析。 后台按照<scene_code>.<group>.<field
  // name> 拼装
  protected Object value; // : 张三 // 可为：张三, ["a","b","c"]...
  protected boolean disabled; // : true // true 才传，false不传
  protected boolean hidden; // : true // true 才传，false不传
  protected String type; // : text  // 可为
  // text,long_text,money,integer,decimal,images,document,date,datetime,time,boolean,
  // prompt_message(表示这个仅是一段文本)
  protected Object candidateValues; // : {     key1:value1,      key2:value2   }
  protected String errorMessage; // : 名字必须大于3个字符 // 大部分情况没有

  // ----- 下面的如果考虑流量可以裁剪掉，用spec查
  protected String label; // : 姓名
  protected String placeholder; // : 请输入姓名
  protected String tipsTitle; // : 注意
  protected String tipsContent; // : 请与身份证一致
  protected String icon; // ：human
  protected boolean required = true; // : true
  protected boolean multiple =
      false; // : true => 只有candidateValues有值才有效。 单选的，value就是type表示的类型；多选的，value是json数组。
  protected String
      candidateValuesApi; // : wxappService/getCandidateCity/:grp_1.male.province/  => 只有级联变动的字段才有
  protected String minimum; // : 2 因为字段的值有很多类型,所以 min/max 的含义会不同, 可能表示长度范围,也可能表示值范围
  protected String maximum; // : 20
  protected List<Map<String, Object>> rules;

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

  public boolean isDisabled() {
    return disabled;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Object getCandidateValues() {
    return candidateValues;
  }

  public void setCandidateValues(Object candidateValues) {
    this.candidateValues = candidateValues;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getPlaceholder() {
    return placeholder;
  }

  public void setPlaceholder(String placeholder) {
    this.placeholder = placeholder;
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

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public boolean isRequired() {
    return required;
  }

  public void setRequired(boolean required) {
    this.required = required;
  }

  public boolean isMultiple() {
    return multiple;
  }

  public void setMultiple(boolean multiple) {
    this.multiple = multiple;
  }

  public String getCandidateValuesApi() {
    return candidateValuesApi;
  }

  public void setCandidateValuesApi(String candidateValuesApi) {
    this.candidateValuesApi = candidateValuesApi;
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

  public boolean isHidden() {
    return hidden;
  }

  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  public List<Map<String, Object>> getRules() {
    return rules;
  }

  public void setRules(List<Map<String, Object>> rules) {
    this.rules = rules;
  }
}
