package com.terapico.changerequest;

import java.util.List;

public class CRSceneSpec {
  protected String name;
  protected String title;
  protected int index;
  protected boolean canSkip;
  protected List<CRGroupSpec> groups;

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

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public boolean isCanSkip() {
    return canSkip;
  }

  public void setCanSkip(boolean canSkip) {
    this.canSkip = canSkip;
  }

  public List<CRGroupSpec> getGroups() {
    return groups;
  }

  public void setGroups(List<CRGroupSpec> groups) {
    this.groups = groups;
  }
}
