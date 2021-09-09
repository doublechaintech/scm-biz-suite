package com.terapico.caf.viewcomponent;

import com.terapico.utils.TextUtil;
import java.util.List;

public abstract class BaseVC implements VComponent {

  protected String id;
  protected String componentType;
  protected String linkToUrl;

  public void setLinkToUrl(String linkToUrl) {
    this.linkToUrl = linkToUrl;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setComponentType(String componentType) {
    this.componentType = componentType;
  }

  @Override
  public String getId() {
    return this.id;
  }

  @Override
  public String getComponentType() {
    return this.componentType;
  }

  @Override
  public String getLinkToUrl() {
    return linkToUrl;
  }

  protected String toStandardAttributeName(String attrName) {
    return TextUtil.uncapFirstChar(TextUtil.toCamelCase(attrName));
  }

  public abstract BaseVC setAttribute(String attrName, Object value);

  protected boolean checkAttributeValueAssignable(
      Object value, Class<?> valueType, String errMessage) {
    if (value == null) {
      return true;
    }
    if (value.getClass().isAssignableFrom(valueType)) {
      return true;
    }
    throw new RuntimeException(errMessage);
  }

  protected boolean checkAttributeValueAssignableFromList(
      Object value, Class<?> valueType, String errMessage) {
    if (value == null) {
      return true;
    }
    if (!(value instanceof List)) {
      throw new RuntimeException(errMessage);
    }
    List<Object> valueList = (List<Object>) value;
    for (Object val : valueList) {
      if (!(value.getClass().isAssignableFrom(valueType))) {
        throw new RuntimeException(errMessage);
      }
    }
    return true;
  }

  protected boolean handledByBaseAttribute(String attrName, Object value) {
    switch (attrName) {
      case "id":
        if (checkAttributeValueAssignable(
            value, String.class, this.getComponentType() + "的id必须是String类型")) {
          setId((String) value);
        }
        return true;
      case "linkToUrl":
        if (checkAttributeValueAssignable(
            value, String.class, this.getComponentType() + "的linkToUrl必须是String类型")) {
          setLinkToUrl((String) value);
        }
        return true;
      default:
        return false;
    }
  }
}
