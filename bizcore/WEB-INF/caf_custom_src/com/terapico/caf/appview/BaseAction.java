package com.terapico.caf.appview;

public class BaseAction {
  protected String code;
  protected String title;
  protected String linkToUrl;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLinkToUrl() {
    return linkToUrl;
  }

  public void setLinkToUrl(String linkToUrl) {
    this.linkToUrl = linkToUrl;
  }
}
