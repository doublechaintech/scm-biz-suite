package com.terapico.caf.viewcomponent;

public class VComponentAction extends BaseVC {
  protected String code;
  protected String title;
  protected String imageUrl;
  protected String icon;
  protected Boolean disabled;
  protected String group;

  public VComponentAction() {
    super();
    this.setComponentType(VComponent.ACTION);
  }

  public VComponentAction id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentAction linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getCode() {
    return this.code;
  }

  public void setCode(String value) {
    this.code = value;
  }

  public VComponentAction code(String value) {
    this.code = value;
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  public VComponentAction title(String value) {
    this.title = value;
    return this;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String value) {
    this.imageUrl = value;
  }

  public VComponentAction imageUrl(String value) {
    this.imageUrl = value;
    return this;
  }

  public String getIcon() {
    return this.icon;
  }

  public void setIcon(String value) {
    this.icon = value;
  }

  public VComponentAction icon(String value) {
    this.icon = value;
    return this;
  }

  public Boolean getDisabled() {
    return this.disabled;
  }

  public void setDisabled(Boolean value) {
    this.disabled = value;
  }

  public VComponentAction disabled(Boolean value) {
    this.disabled = value;
    return this;
  }

  public String getGroup() {
    return this.group;
  }

  public void setGroup(String value) {
    this.group = value;
  }

  public VComponentAction group(String value) {
    this.group = value;
    return this;
  }

  public VComponentAction setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "code":
        if (checkAttributeValueAssignable(value, String.class, "action的code必须是String类型")) {
          setCode((String) value);
        }
        return this;
      case "title":
        if (checkAttributeValueAssignable(value, String.class, "action的title必须是String类型")) {
          setTitle((String) value);
        }
        return this;
      case "imageUrl":
        if (checkAttributeValueAssignable(value, String.class, "action的imageUrl必须是String类型")) {
          setImageUrl((String) value);
        }
        return this;
      case "icon":
        if (checkAttributeValueAssignable(value, String.class, "action的icon必须是String类型")) {
          setIcon((String) value);
        }
        return this;
      case "disabled":
        if (checkAttributeValueAssignable(value, Boolean.class, "action的disabled必须是Boolean类型")) {
          setDisabled((Boolean) value);
        }
        return this;
      case "group":
        if (checkAttributeValueAssignable(value, String.class, "action的group必须是String类型")) {
          setGroup((String) value);
        }
        return this;
      default:
        throw new RuntimeException("action 不支持设置属性 " + stdAttrName);
    }
  }
}
