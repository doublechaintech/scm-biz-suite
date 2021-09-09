package com.terapico.caf.viewcomponent;

import java.util.ArrayList;
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
  protected String flag;
  protected String level;
  protected String mode;
  protected List<VComponentInfoListItem> infoList;

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

  public VComponentCardInList actionList(VComponentAction value) {
    ensureActionList().add(value);
    return this;
  }

  protected List<VComponentAction> ensureActionList() {
    if (this.actionList != null) {
      return this.actionList;
    }
    this.actionList = new ArrayList<>();
    return this.actionList;
  }

  public String getFlag() {
    return this.flag;
  }

  public void setFlag(String value) {
    this.flag = value;
  }

  public VComponentCardInList flag(String value) {
    this.flag = value;
    return this;
  }

  public String getLevel() {
    return this.level;
  }

  public void setLevel(String value) {
    this.level = value;
  }

  public VComponentCardInList level(String value) {
    this.level = value;
    return this;
  }

  public String getMode() {
    return this.mode;
  }

  public void setMode(String value) {
    this.mode = value;
  }

  public VComponentCardInList mode(String value) {
    this.mode = value;
    return this;
  }

  public List<VComponentInfoListItem> getInfoList() {
    return this.infoList;
  }

  public void setInfoList(List<VComponentInfoListItem> value) {
    this.infoList = value;
  }

  public VComponentCardInList infoList(List<VComponentInfoListItem> value) {
    this.infoList = value;
    return this;
  }

  public VComponentCardInList infoList(VComponentInfoListItem value) {
    ensureInfoList().add(value);
    return this;
  }

  protected List<VComponentInfoListItem> ensureInfoList() {
    if (this.infoList != null) {
      return this.infoList;
    }
    this.infoList = new ArrayList<>();
    return this.infoList;
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
      case "flag":
        if (checkAttributeValueAssignable(value, String.class, "card_in_list的flag必须是String类型")) {
          setFlag((String) value);
        }
        return this;
      case "level":
        if (checkAttributeValueAssignable(value, String.class, "card_in_list的level必须是String类型")) {
          setLevel((String) value);
        }
        return this;
      case "mode":
        if (checkAttributeValueAssignable(value, String.class, "card_in_list的mode必须是String类型")) {
          setMode((String) value);
        }
        return this;
      case "infoList":
        if (checkAttributeValueAssignableFromList(
            value,
            VComponentInfoListItem.class,
            "card_in_list的infoList必须是List<VComponentInfoListItem>类型")) {
          setInfoList((List<VComponentInfoListItem>) value);
        }
        return this;
      default:
        throw new RuntimeException("card_in_list 不支持设置属性 " + stdAttrName);
    }
  }

  public VComponentCardInList blankInfoList() {
    ensureInfoList().add(null);
    return this;
  }

  public VComponentCardInList infoList(String id, String title, String value) {
    ensureInfoList().add(new VComponentInfoListItem().id(id).title(title).value(value));
    ensureInfoList().add(null);
    return this;
  }
}
