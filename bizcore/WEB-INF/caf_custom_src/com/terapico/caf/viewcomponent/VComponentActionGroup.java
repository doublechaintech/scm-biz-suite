package com.terapico.caf.viewcomponent;

import java.util.ArrayList;
import java.util.List;

public class VComponentActionGroup extends BaseVC {
  protected String title;
  protected String brief;
  protected String icon;
  protected String displayMode;
  protected List<VComponentAction> actionList;

  public VComponentActionGroup() {
    super();
    this.setComponentType(VComponent.ACTION_GROUP);
  }

  public VComponentActionGroup id(String id) {
    this.setId(id);
    return this;
  }

  public VComponentActionGroup linkToUrl(String linkToUrl) {
    this.setLinkToUrl(linkToUrl);
    return this;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String value) {
    this.title = value;
  }

  public VComponentActionGroup title(String value) {
    this.title = value;
    return this;
  }

  public String getBrief() {
    return this.brief;
  }

  public void setBrief(String value) {
    this.brief = value;
  }

  public VComponentActionGroup brief(String value) {
    this.brief = value;
    return this;
  }

  public String getIcon() {
    return this.icon;
  }

  public void setIcon(String value) {
    this.icon = value;
  }

  public VComponentActionGroup icon(String value) {
    this.icon = value;
    return this;
  }

  public String getDisplayMode() {
    return this.displayMode;
  }

  public void setDisplayMode(String value) {
    this.displayMode = value;
  }

  public VComponentActionGroup displayMode(String value) {
    this.displayMode = value;
    return this;
  }

  public List<VComponentAction> getActionList() {
    return this.actionList;
  }

  public void setActionList(List<VComponentAction> value) {
    this.actionList = value;
  }

  public VComponentActionGroup actionList(List<VComponentAction> value) {
    this.actionList = value;
    return this;
  }

  public VComponentActionGroup actionList(VComponentAction value) {
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

  public VComponentActionGroup setAttribute(String attrName, Object value) {
    String stdAttrName = toStandardAttributeName(attrName);
    if (handledByBaseAttribute(stdAttrName, value)) {
      return this;
    }
    switch (attrName) {
      case "title":
        if (checkAttributeValueAssignable(value, String.class, "action_group的title必须是String类型")) {
          setTitle((String) value);
        }
        return this;
      case "brief":
        if (checkAttributeValueAssignable(value, String.class, "action_group的brief必须是String类型")) {
          setBrief((String) value);
        }
        return this;
      case "icon":
        if (checkAttributeValueAssignable(value, String.class, "action_group的icon必须是String类型")) {
          setIcon((String) value);
        }
        return this;
      case "displayMode":
        if (checkAttributeValueAssignable(
            value, String.class, "action_group的displayMode必须是String类型")) {
          setDisplayMode((String) value);
        }
        return this;
      case "actionList":
        if (checkAttributeValueAssignableFromList(
            value, VComponentAction.class, "action_group的actionList必须是List<VComponentAction>类型")) {
          setActionList((List<VComponentAction>) value);
        }
        return this;
      default:
        throw new RuntimeException("action_group 不支持设置属性 " + stdAttrName);
    }
  }
}
