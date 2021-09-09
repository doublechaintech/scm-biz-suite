package com.terapico.changerequest;

public class CRGroupSpec {
  protected String name;
  protected String title;
  protected String modelName;
  protected boolean multiple;
  protected boolean mustHave = true;
  protected int minimumNumber;
  protected int maximumNumber;

  public boolean isMultiple() {
    return multiple;
  }

  public void setMultiple(boolean multiple) {
    this.multiple = multiple;
  }

  public boolean isMustHave() {
    return mustHave;
  }

  public void setMustHave(boolean mustHave) {
    this.mustHave = mustHave;
  }

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

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public int getMinimumNumber() {
    return minimumNumber;
  }

  public void setMinimumNumber(int minimumNumber) {
    this.minimumNumber = minimumNumber;
  }

  public int getMaximumNumber() {
    return maximumNumber;
  }

  public void setMaximumNumber(int maximumNumber) {
    this.maximumNumber = maximumNumber;
  }
}
