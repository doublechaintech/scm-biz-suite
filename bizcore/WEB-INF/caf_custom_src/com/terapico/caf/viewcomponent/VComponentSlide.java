package com.terapico.caf.viewcomponent;

public class VComponentSlide extends BaseVC {
  protected String name;
  protected String imageUrl;
  protected String videoUrl;

  public VComponentSlide() {
    super();
    this.setComponentType(VComponent.SLIDE);
  }

  public VComponentSlide id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentSlide linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String value) {
    this.name = value;
  }

  public VComponentSlide name(String value) {
    this.name = value;
    return this;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String value) {
    this.imageUrl = value;
  }

  public VComponentSlide imageUrl(String value) {
    this.imageUrl = value;
    return this;
  }

  public String getVideoUrl() {
    return this.videoUrl;
  }

  public void setVideoUrl(String value) {
    this.videoUrl = value;
  }

  public VComponentSlide videoUrl(String value) {
    this.videoUrl = value;
    return this;
  }

  public VComponentSlide setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "name":
        if (checkAttributeValueAssignable(value, String.class, "slide的name必须是String类型")) {
          setName((String) value);
        }
        return this;
      case "imageUrl":
        if (checkAttributeValueAssignable(value, String.class, "slide的imageUrl必须是String类型")) {
          setImageUrl((String) value);
        }
        return this;
      case "videoUrl":
        if (checkAttributeValueAssignable(value, String.class, "slide的videoUrl必须是String类型")) {
          setVideoUrl((String) value);
        }
        return this;
      default:
        throw new RuntimeException("slide 不支持设置属性 " + stdAttrName);
    }
  }
}
