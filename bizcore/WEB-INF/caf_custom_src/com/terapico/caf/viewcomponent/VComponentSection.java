package com.terapico.caf.viewcomponent;

public class VComponentSection extends BaseVC {
  protected String title;
  protected String brief;
  protected String icon;
  protected String viewGroup;
  protected String displayMode;

  public VComponentSection() {
    super();
    this.setComponentType(VComponent.SECTION);
  }

  public VComponentSection id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentSection linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  public VComponentSection title(String value) {
    this.title = value;
    return this;
  }

  public String getBrief() {
    return this.brief;
  }

  public void setBrief(String value) {
    this.brief = value;
  }

  public VComponentSection brief(String value) {
    this.brief = value;
    return this;
  }

  public String getIcon() {
    return this.icon;
  }

  public void setIcon(String value) {
    this.icon = value;
  }

  public VComponentSection icon(String value) {
    this.icon = value;
    return this;
  }

  public String getViewGroup() {
    return this.viewGroup;
  }

  public void setViewGroup(String value) {
    this.viewGroup = value;
  }

  public VComponentSection viewGroup(String value) {
    this.viewGroup = value;
    return this;
  }

  public String getDisplayMode() {
    return this.displayMode;
  }

  public void setDisplayMode(String value) {
    this.displayMode = value;
  }

  public VComponentSection displayMode(String value) {
    this.displayMode = value;
    return this;
  }

  public VComponentSection setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "title":
        if (checkAttributeValueAssignable(value, String.class, "section的title必须是String类型")) {
          setTitle((String) value);
        }
        return this;
      case "brief":
        if (checkAttributeValueAssignable(value, String.class, "section的brief必须是String类型")) {
          setBrief((String) value);
        }
        return this;
      case "icon":
        if (checkAttributeValueAssignable(value, String.class, "section的icon必须是String类型")) {
          setIcon((String) value);
        }
        return this;
      case "viewGroup":
        if (checkAttributeValueAssignable(value, String.class, "section的viewGroup必须是String类型")) {
          setViewGroup((String) value);
        }
        return this;
      case "displayMode":
        if (checkAttributeValueAssignable(value, String.class, "section的displayMode必须是String类型")) {
          setDisplayMode((String) value);
        }
        return this;
      default:
        throw new RuntimeException("section 不支持设置属性 " + stdAttrName);
    }
  }
}
