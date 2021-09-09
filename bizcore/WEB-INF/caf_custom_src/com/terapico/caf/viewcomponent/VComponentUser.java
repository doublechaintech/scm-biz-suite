package com.terapico.caf.viewcomponent;

public class VComponentUser extends BaseVC {
  protected String name;
  protected String brief;
  protected String avatar;

  public VComponentUser() {
    super();
    this.setComponentType(VComponent.USER);
  }

  public VComponentUser id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentUser linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public VComponentUser name(String value) {
    this.name = value;
    return this;
  }

  public String getBrief() {
    return this.brief;
  }

  public void setBrief(String value) {
    this.brief = value;
  }

  public VComponentUser brief(String value) {
    this.brief = value;
    return this;
  }

  public String getAvatar() {
    return this.avatar;
  }

  public void setAvatar(String value) {
    this.avatar = value;
  }

  public VComponentUser avatar(String value) {
    this.avatar = value;
    return this;
  }

  public VComponentUser setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "name":
        if (checkAttributeValueAssignable(value, String.class, "user的name必须是String类型")) {
          setName((String) value);
        }
        return this;
      case "brief":
        if (checkAttributeValueAssignable(value, String.class, "user的brief必须是String类型")) {
          setBrief((String) value);
        }
        return this;
      case "avatar":
        if (checkAttributeValueAssignable(value, String.class, "user的avatar必须是String类型")) {
          setAvatar((String) value);
        }
        return this;
      default:
        throw new RuntimeException("user 不支持设置属性 " + stdAttrName);
    }
  }
}
