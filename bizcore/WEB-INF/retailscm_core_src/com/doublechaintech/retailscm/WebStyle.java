package com.doublechaintech.retailscm;

public class WebStyle {

  public String backgroundColor;
  public String color;

  public String getClassNames() {
    return classNames;
  }

  public String getNotes() {
    return notes;
  }

  public WebStyle setNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public WebStyle setClassNames(String classNames) {
    this.classNames = classNames;
    return this;
  }

  public String classNames;
  public String notes;

  public static WebStyle withBackgroundColor(String color) {
    WebStyle style = new WebStyle();
    style.setBackgroundColor(color);
    return style;
  }

  public WebStyle bindToTarget(BaseEntity baseEntity) {

    baseEntity.setDynaProp("style", this);
    return this;
  }

  public static WebStyle withClassNames(String classNames) {
    WebStyle style = new WebStyle();
    style.setClassNames(classNames);
    return style;
  }

  // tableRowDisabled tableRowRedFont'

  public static WebStyle withFontColor(String color) {
    WebStyle style = new WebStyle();
    style.setColor(color);
    return style;
  }

  public String getBackgroundColor() {
    return backgroundColor;
  }

  public WebStyle setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
    return this;
  }

  public String getColor() {
    return color;
  }

  public WebStyle setColor(String color) {
    this.color = color;
    return this;
  }
}
