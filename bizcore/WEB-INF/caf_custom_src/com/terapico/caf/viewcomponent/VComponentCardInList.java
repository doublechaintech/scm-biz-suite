package com.terapico.caf.viewcomponent;

import java.util.Date;
import java.util.List;

public class VComponentCardInList extends BaseVC {
  protected String title;
  protected String brief;
  protected String imageUrl;
  protected String status;
  protected String displayMode;
  protected String documentUrl;
  protected Date createTime;
  protected List<VComponentAction> actionList;

  public VComponentCardInList() {
    super();
    this.setComponentType(VComponent.CARD_IN_LIST);
  }

  public VComponentCardInList id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentCardInList linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  public VComponentCardInList title(String value) {
    this.title = value;
    return this;
  }

  public String getBrief() {
    return this.brief;
  }

  public void setBrief(String value) {
    this.brief = value;
  }

  public VComponentCardInList brief(String value) {
    this.brief = value;
    return this;
  }

  public String getImageUrl() {
    return this.imageUrl;
  }

  public void setImageUrl(String value) {
    this.imageUrl = value;
  }

  public VComponentCardInList imageUrl(String value) {
    this.imageUrl = value;
    return this;
  }

  public String getStatus() {
    return this.status;
  }

  public void setStatus(String value) {
    this.status = value;
  }

  public VComponentCardInList status(String value) {
    this.status = value;
    return this;
  }

  public String getDisplayMode() {
    return this.displayMode;
  }

  public void setDisplayMode(String value) {
    this.displayMode = value;
  }

  public VComponentCardInList displayMode(String value) {
    this.displayMode = value;
    return this;
  }

  public String getDocumentUrl() {
    return this.documentUrl;
  }

  public void setDocumentUrl(String value) {
    this.documentUrl = value;
  }

  public VComponentCardInList documentUrl(String value) {
    this.documentUrl = value;
    return this;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Date value) {
    this.createTime = value;
  }

  public VComponentCardInList createTime(Date value) {
    this.createTime = value;
    return this;
  }

  public List<VComponentAction> getActionList() {
    return this.actionList;
  }

  public void setActionList(List<VComponentAction> value) {
    this.actionList = value;
  }

  public VComponentCardInList actionList(List<VComponentAction> value) {
    this.actionList = value;
    return this;
  }

  public VComponentCardInList setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "title":
        if (checkAttributeValueAssignable(value, String.class, "card_in_list的title必须是String类型")) {
          setTitle((String) value);
        }
        return this;
      case "brief":
        if (checkAttributeValueAssignable(value, String.class, "card_in_list的brief必须是String类型")) {
          setBrief((String) value);
        }
        return this;
      case "imageUrl":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_list的imageUrl必须是String类型")) {
          setImageUrl((String) value);
        }
        return this;
      case "status":
        if (checkAttributeValueAssignable(value, String.class, "card_in_list的status必须是String类型")) {
          setStatus((String) value);
        }
        return this;
      case "displayMode":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_list的displayMode必须是String类型")) {
          setDisplayMode((String) value);
        }
        return this;
      case "documentUrl":
        if (checkAttributeValueAssignable(
            value, String.class, "card_in_list的documentUrl必须是String类型")) {
          setDocumentUrl((String) value);
        }
        return this;
      case "createTime":
        if (checkAttributeValueAssignable(value, Date.class, "card_in_list的createTime必须是Date类型")) {
          setCreateTime((Date) value);
        }
        return this;
      case "actionList":
        if (checkAttributeValueAssignableFromList(
            value, VComponentAction.class, "card_in_list的actionList必须是List<VComponentAction>类型")) {
          setActionList((List<VComponentAction>) value);
        }
        return this;
      default:
        throw new RuntimeException("card_in_list 不支持设置属性 " + stdAttrName);
    }
  }
}
