package com.terapico.changerequest;

import java.util.List;

public class CRSpec {
  protected String name;
  protected String title;
  protected String brief;
  protected String changeRequestType;
  protected String requestPrefix;
  protected List<CRSceneSpec> sceneList;
  protected List<CRFieldSpec> fieldList;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBrief() {
    return brief;
  }

  public void setBrief(String brief) {
    this.brief = brief;
  }

  public String getChangeRequestType() {
    return changeRequestType;
  }

  public void setChangeRequestType(String changeRequestType) {
    this.changeRequestType = changeRequestType;
  }

  public List<CRSceneSpec> getSceneList() {
    return sceneList;
  }

  public void setSceneList(List<CRSceneSpec> sceneList) {
    this.sceneList = sceneList;
  }

  public List<CRFieldSpec> getFieldList() {
    return fieldList;
  }

  public void setFieldList(List<CRFieldSpec> fieldList) {
    this.fieldList = fieldList;
  }

  public String getRequestPrefix() {
    return requestPrefix;
  }

  public void setRequestPrefix(String requestPrefix) {
    this.requestPrefix = requestPrefix;
  }

  public boolean isOnlyOneScence(String sceneCode) {
    int sceneIndex = findSceneCodeIndex(sceneCode);
    if (sceneIndex != 0) {
      return false;
    }
    if (getSceneList().size() == 1) {
      return true;
    }
    return false;
  }

  public boolean isFirstScence(String sceneCode) {
    int sceneIndex = findSceneCodeIndex(sceneCode);
    if (sceneIndex != 0) {
      return false;
    }
    if (getSceneList().size() >= 1) {
      return true;
    }
    return false;
  }

  public boolean isLastScence(String sceneCode) {
    int sceneIndex = findSceneCodeIndex(sceneCode);
    if (sceneIndex < 0) {
      return false;
    }
    if (getSceneList().size() == (sceneIndex + 1)) {
      return true;
    }
    return false;
  }

  protected int findSceneCodeIndex(String sceneCode) {
    if (this.getSceneList() == null) {
      return -1;
    }
    for (int i = 0; i < sceneList.size(); i++) {
      if (sceneList.get(i).getName().equals(sceneCode)) {
        return i;
      }
    }
    return -1;
  }
}
