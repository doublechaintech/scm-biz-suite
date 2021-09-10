package com.terapico.menu;

import java.util.List;

public class Menu {
  private String code;
  private String name;
  private String action;
  private String icon;
  private List<Menu> children;

  public String getCode() {
    return code;
  }

  public void setCode(String pCode) {
    code = pCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String pName) {
    name = pName;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String pAction) {
    action = pAction;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String pIcon) {
    icon = pIcon;
  }

  public List<Menu> getChildren() {
    return children;
  }

  public void setChildren(List<Menu> pChildren) {
    children = pChildren;
  }
}
