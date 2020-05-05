package com.terapico.caf.viewcomponent;

public class VComponentCardInSection extends BaseVC {
  protected String title;
  protected String brief;
  protected String imageUrl;
  protected String status;

  public VComponentCardInSection() {
    super();
    this.setComponentType(VComponent.CARD_IN_SECTION);
  }

  public VComponentCardInSection id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentCardInSection linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  public VComponentCardInSection title(String value) {
    this.title = value;
    return this;
  }

  public String getBrief() {
    return this.brief;
  }

  public void setBrief(String value) {
    this.brief = value;
  }

  public VComponentCardInSection brief(String value) {
    this.brief = value;
    return this;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String value) {
    this.imageUrl = value;
  }

  public VComponentCardInSection imageUrl(String value) {
    this.imageUrl = value;
    return this;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String value) {
    this.status = value;
  }

  public VComponentCardInSection status(String value) {
    this.status = value;
    return this;
  }

  public VComponentCardInSection setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "title":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_section的title必须是String类型")) {
          setTitle((String) value);
        }
        return this;
      case "brief":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_section的brief必须是String类型")) {
          setBrief((String) value);
        }
        return this;
      case "imageUrl":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_section的imageUrl必须是String类型")) {
          setImageUrl((String) value);
        }
        return this;
      case "status":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_section的status必须是String类型")) {
          setStatus((String) value);
        }
        return this;
      default:
        throw new RuntimeException("card_in_section 不支持设置属性 " + stdAttrName);
    }
  }
}
