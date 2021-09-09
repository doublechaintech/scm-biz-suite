package com.terapico.changerequest;

import java.util.Map;

public class Spec {
  protected String name;
  protected String title;
  protected Map<String, CRSpec> crSpecs;

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

  public Map<String, CRSpec> getCrSpecs() {
    return crSpecs;
  }

  public void setCrSpecs(Map<String, CRSpec> crSpecs) {
    this.crSpecs = crSpecs;
  }
}
