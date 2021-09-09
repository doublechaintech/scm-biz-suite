package com.terapico.caf.viewcomponent;

public class VComponentInfoListItem extends BaseVC {
  protected String title;
  protected String value;

  public VComponentInfoListItem() {
    super();
    this.setComponentType(VComponent.INFO_LIST_ITEM);
  }

  public VComponentInfoListItem id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentInfoListItem linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  public VComponentInfoListItem title(String value) {
    this.title = value;
    return this;
  }

  public String getValue() {
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public VComponentInfoListItem value(String value) {
    this.value = value;
    return this;
  }

  public VComponentInfoListItem setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "title":
        if (checkAttributeValueAssignable(value, String.class, "info_list_item的title必须是String类型")) {
          setTitle((String) value);
        }
        return this;
      case "value":
        if (checkAttributeValueAssignable(value, String.class, "info_list_item的value必须是String类型")) {
          setValue((String) value);
        }
        return this;
      default:
        throw new RuntimeException("info_list_item 不支持设置属性 " + stdAttrName);
    }
  }
}
